package io.github.grazianii.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Column
    private Integer id;

    @Column (length = 100)
    private String nome;

    @Column (length = 11)
    private String cpf;

    @Column (length = 11)
    private long telefone;

    @Column
    private float saldo_cc;

    @JsonIgnore
    @Column
    private float score_credito;

    @Column
    private boolean correntista;

    public Cliente(String nome, String cpf, long telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}