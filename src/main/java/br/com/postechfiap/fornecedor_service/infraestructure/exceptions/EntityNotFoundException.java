package br.com.postechfiap.fornecedor_service.infraestructure.exceptions;

public class EntityNotFoundException extends ApiException {
  public EntityNotFoundException(String entityName, String genero) {
    super(entityName + " não encontrad" + genero + ".");
  }
}
