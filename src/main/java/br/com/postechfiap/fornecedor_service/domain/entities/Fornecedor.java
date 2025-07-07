package br.com.postechfiap.fornecedor_service.domain.entities;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Fornecedor {

    private Long id;

    @Setter
    private String nome;

    @Setter
    private String cnpj;

    @Setter
    private String telefone;

    @Setter
    private String email;

    @Setter
    private boolean ativo;
}
