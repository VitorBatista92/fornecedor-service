package br.com.postechfiap.fornecedor_service.infraestructure.exceptions.fornecedor;

import br.com.postechfiap.fornecedor_service.infraestructure.exceptions.ApiException;
import br.com.postechfiap.fornecedor_service.infraestructure.exceptions.EntityNotFoundException;

public class FornecedorNaoEncontradoException extends EntityNotFoundException {
    public FornecedorNaoEncontradoException() {
        super("Fornecedor", "o.");
    }
}
