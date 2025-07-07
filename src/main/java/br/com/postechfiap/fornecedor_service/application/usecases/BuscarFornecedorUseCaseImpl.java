package br.com.postechfiap.fornecedor_service.application.usecases;

import br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor.BuscarFornecedorUseCase;
import br.com.postechfiap.fornecedor_service.infraestructure.adapter.FornecedorAdapter;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;
import br.com.postechfiap.fornecedor_service.infraestructure.exceptions.fornecedor.FornecedorNaoEncontradoException;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuscarFornecedorUseCaseImpl implements BuscarFornecedorUseCase {

    private final FornecedorRepository fornecedorRepository;

    @Override
    public List<FornecedorResponse> execute(String nome) {
        List<FornecedorEntity> fornecedores;

        if (nome == null || nome.isBlank()) {
            fornecedores = fornecedorRepository.findAll();
        } else {
            fornecedores = fornecedorRepository.findByNomeContainingIgnoreCase(nome);
        }

        if (fornecedores.isEmpty()) {
            throw new FornecedorNaoEncontradoException();
        }

        return fornecedores.stream()
                .map(FornecedorAdapter::toResponse)
                .toList();
    }
}
