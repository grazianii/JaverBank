package io.github.grazianii.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "contaCorrente")
public class ContaCorrente {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Cliente cliente;

    @Column (name = "score_credito")
    private float score_credito;

    @Column (name = "saldo_cc")
    private float saldo_cc;
}
