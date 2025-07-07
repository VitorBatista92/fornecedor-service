package br.com.postechfiap.fornecedor_service.infraestructure.gateways;

import br.com.postechfiap.fornecedor_service.application.gateways.FornecedorGateway;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FornecedorRepositoryGateway implements FornecedorGateway {

    private final FornecedorRepository repository;

    @Override
    public FornecedorEntity save(FornecedorEntity fornecedor) {
        fornecedor.setCreatedAt(LocalDateTime.now());
        return repository.save(fornecedor);
    }

    @Override
    public List<FornecedorEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<FornecedorEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(FornecedorEntity entity) {

    }

    @Override
    public FornecedorEntity update(FornecedorEntity entity) {
        return null;
    }

    @Override
    public List<FornecedorEntity> findByNomeContainingIgnoreCase(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Optional<FornecedorEntity> findByCnpj(String cnpj) {
        return repository.findByCnpj(cnpj);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
