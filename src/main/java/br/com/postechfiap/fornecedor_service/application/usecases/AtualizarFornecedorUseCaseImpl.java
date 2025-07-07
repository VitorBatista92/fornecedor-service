package br.com.postechfiap.fornecedor_service.application.usecases;

import br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor.AtualizarFornecedorUseCase;
import br.com.postechfiap.fornecedor_service.infraestructure.adapter.FornecedorAdapter;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request.AtualizarFornecedorRequest;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;
import br.com.postechfiap.fornecedor_service.infraestructure.exceptions.fornecedor.FornecedorNaoEncontradoException;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.Tuple;

@Slf4j
@Service
@RequiredArgsConstructor
public class AtualizarFornecedorUseCaseImpl implements AtualizarFornecedorUseCase {

    private final FornecedorRepository fornecedorRepository;

    @Override
    public FornecedorResponse execute(Tuple<AtualizarFornecedorRequest, Long> fornecedorRequestLongTuple) {
        final var request = fornecedorRequestLongTuple._1();
        final var fornecedorId = fornecedorRequestLongTuple._2();
        FornecedorEntity fornecedorDb = fornecedorRepository.findById(fornecedorId).orElseThrow(FornecedorNaoEncontradoException::new);

        fornecedorDb.setNome(request.nome());
        fornecedorDb.setCnpj(request.cnpj());
        fornecedorDb.setEmail(request.email());
        fornecedorDb.setTelefone(request.telefone());

        FornecedorEntity fornecedorAtualizado = fornecedorRepository.save(fornecedorDb);

        return FornecedorAdapter.toResponse(fornecedorAtualizado);
    }
}
