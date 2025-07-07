package br.com.postechfiap.fornecedor_service.application.usecases;

import br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor.CadastrarFornecedorUseCase;
import br.com.postechfiap.fornecedor_service.infraestructure.adapter.FornecedorAdapter;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request.FornecedorRequest;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;
import br.com.postechfiap.fornecedor_service.infraestructure.exceptions.fornecedor.CnpjDuplicadoException;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CadastrarFornecedorUseCaseImpl implements CadastrarFornecedorUseCase {

    private final FornecedorRepository fornecedorRepository;

    @Override
    public FornecedorResponse execute(FornecedorRequest dto) {
        FornecedorEntity fornecedor = FornecedorAdapter.toEntity(dto);

        if (fornecedorRepository.findByCnpj(fornecedor.getCnpj()).isPresent()) {
            throw new CnpjDuplicadoException(fornecedor.getCnpj());
        }

        fornecedor.setAtivo(true);
        FornecedorEntity salvo = fornecedorRepository.save(fornecedor);

        return FornecedorAdapter.toResponse(salvo);
    }
}
