package br.com.postechfiap.fornecedor_service.application.gateways;

import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseGateway<T extends BaseEntity<ID>, ID> {

    T save(T entity);

    List<T> findAll();

    Optional<T> findById(Long id);

    void delete(T entity);

    T update(T entity);
}
