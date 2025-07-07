package br.com.postechfiap.fornecedor_service.infraestructure.adapter;

import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request.FornecedorRequest;
import br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response.FornecedorResponse;
import br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities.FornecedorEntity;

public class FornecedorAdapter {

    public static FornecedorEntity toEntity(FornecedorRequest dto) {
        if (dto == null) return null;

        return FornecedorEntity.builder()
                .nome(dto.nome())
                .cnpj(dto.cnpj())
                .telefone(dto.telefone())
                .email(dto.email())
                .build();
    }

    public static FornecedorResponse toResponse(FornecedorEntity fornecedor) {
        if (fornecedor == null) return null;

        return new FornecedorResponse(
                fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getEmail(),
                fornecedor.getTelefone(),
                fornecedor.isAtivo()
        );
    }
}
