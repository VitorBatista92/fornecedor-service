package br.com.postechfiap.fornecedor_service.application.gateways;

import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;

import java.util.List;
import java.util.Optional;

public interface FornecedorGateway extends BaseGateway<FornecedorEntity, Long> {
    List<FornecedorEntity> findByNomeContainingIgnoreCase(String nome);
    Optional<FornecedorEntity> findByCnpj(String cnpj);
    void deleteById(Long id);
}
