package br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor;

import br.com.postechfiap.fornecedor_service.application.interfaces.UseCase;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request.FornecedorRequestParams;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;

import java.util.List;

public interface BuscarFornecedorUseCase extends UseCase<String, List<FornecedorResponse>> {
}
