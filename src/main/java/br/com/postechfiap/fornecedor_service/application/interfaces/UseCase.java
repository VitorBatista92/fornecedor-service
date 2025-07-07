package br.com.postechfiap.fornecedor_service.application.interfaces;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
