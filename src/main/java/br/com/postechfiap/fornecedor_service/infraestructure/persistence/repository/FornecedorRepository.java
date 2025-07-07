package br.com.postechfiap.fornecedor_service.infraestructure.persistence.repository;

import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
    List<FornecedorEntity> findByNomeContainingIgnoreCase(String nome);
    Optional<FornecedorEntity> findByCnpj(String cnpj);
}
