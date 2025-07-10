package br.com.postechfiap.fornecedor_service.application.interfaces.usecases.fornecedor;

import br.com.postechfiap.fornecedor_service.application.interfaces.UseCase;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;

public interface BuscarFornecedorPorIdUseCase extends UseCase<Long, FornecedorResponse> {
}
