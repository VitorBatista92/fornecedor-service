package br.com.postechfiap.fornecedor_service.application.usecases;

import br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor.BuscarFornecedorPorIdUseCase;
import br.com.postechfiap.fornecedor_service.infraestructure.adapter.FornecedorAdapter;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;
import br.com.postechfiap.fornecedor_service.infraestructure.exceptions.fornecedor.FornecedorNaoEncontradoException;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuscarFornecedorPorIdUseCaseImpl implements BuscarFornecedorPorIdUseCase {

    private final FornecedorRepository fornecedorRepository;

    @Override
    public FornecedorResponse execute(Long id) {
        FornecedorEntity fornecedor = fornecedorRepository.findById(id)
                .orElseThrow(FornecedorNaoEncontradoException::new);

        return FornecedorAdapter.toResponse(fornecedor);
    }
}
