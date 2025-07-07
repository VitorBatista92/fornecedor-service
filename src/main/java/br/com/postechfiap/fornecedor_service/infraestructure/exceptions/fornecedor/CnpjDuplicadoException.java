package br.com.postechfiap.fornecedor_service.infraestructure.exceptions.fornecedor;

import br.com.postechfiap.fornecedor_service.infraestructure.exceptions.ApiException;

public class CnpjDuplicadoException extends ApiException {
    public CnpjDuplicadoException(String cnpj) {
        super("Ja existe um Fornecedor com o CPNJ: " + cnpj + ", cadastrado no sistema.");
    }
}
