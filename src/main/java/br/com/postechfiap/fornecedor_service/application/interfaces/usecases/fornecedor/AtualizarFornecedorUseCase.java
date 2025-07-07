package br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor;

import br.com.postechfiap.fornecedor_service.application.interfaces.UseCase;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request.AtualizarFornecedorRequest;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;
import org.yaml.snakeyaml.util.Tuple;

public interface AtualizarFornecedorUseCase extends UseCase<Tuple<AtualizarFornecedorRequest, Long>, FornecedorResponse> {
}
