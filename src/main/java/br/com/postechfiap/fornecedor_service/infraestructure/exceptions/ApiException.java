package br.com.postechfiap.fornecedor_service.infraestructure.exceptions;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
