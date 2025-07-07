package br.com.postechfiap.fornecedor_service.infraestructure.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder(toBuilder = true)
@Table(name = FornecedorEntity.TABLE_NAME)
@Entity
public class FornecedorEntity extends BaseEntity<Long>{

    public static final String TABLE_NAME = "fornecedor";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_seq_gen")
    @SequenceGenerator(name = "fornecedor_seq_gen", sequenceName = "fornecedor_id_seq", allocationSize = 1)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String nome;

    @Setter
    @Column(nullable = false, unique = true)
    private String cnpj;

    @Setter
    @Column(nullable = false)
    private String telefone;

    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    private boolean ativo;
}
