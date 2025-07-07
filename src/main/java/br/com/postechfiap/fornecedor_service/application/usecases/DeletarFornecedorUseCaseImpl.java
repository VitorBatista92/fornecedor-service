package br.com.postechfiap.fornecedor_service.application.usecases;

import br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor.DeletarFornecedorUseCase;
import br.com.postechfiap.fornecedor_service.infraestructure.exceptions.fornecedor.FornecedorNaoEncontradoException;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeletarFornecedorUseCaseImpl implements DeletarFornecedorUseCase {

    private final FornecedorRepository fornecedorRepository;

    @Override
    public String execute(Long id) {

        FornecedorEntity fornecedor =fornecedorRepository.findById(id).orElseThrow(FornecedorNaoEncontradoException::new);

        fornecedor.setAtivo(false);
        fornecedor.delete();
        fornecedorRepository.save(fornecedor);

        return fornecedor.getNome();
    }
}
