package br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AtualizarFornecedorRequest(
        String nome,
        @CNPJ(message = "O formato do CNPJ deve ser: 00.000.000/0000-00")
        String cnpj,
        @Size(min = 11, max = 14)
        String telefone,
        @Email
        String email
) {
}
