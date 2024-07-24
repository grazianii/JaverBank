package io.github.grazianii.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column (length = 100)
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String login;

    @Column (length = 50)
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;

    @Column (length = 100)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Transient // Indica que o atributo abaixo não será representado no banco de dados
    private List<String> permissao;
}