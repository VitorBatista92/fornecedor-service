package br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record FornecedorResponse(
        Long id,
        String nome,
        String cnpj,
        String telefone,
        String email,
        boolean ativo
) {
}
