package br.com.postechfiap.fornecedor_service.infraestructure.dto.fornecedor.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record FornecedorRequest(
        @NotBlank(message = "O nome é obrigatório!")
        String nome,
        @CNPJ(message = "O formato do CNPJ deve ser: 00.000.000/0000-00")
        @NotBlank(message = "O CNPJ é obrigatório!")
        String cnpj,
        @NotBlank(message = "O Telefone é obrigatório!")
        @Size(min = 11, max = 14)
        String telefone,
        @NotBlank(message = "O e-mail é obrigatório!")
        @Email(message = "O e-mail é inválido!")
        String email
) {
}
