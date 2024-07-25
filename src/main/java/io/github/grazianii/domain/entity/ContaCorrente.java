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

    public void setSaldo_cc(float saldo_cc){
        this.saldo_cc = saldo_cc;
        updateScoreCredito();
    }

    // Atualiza o score da conta corrente com base no saldo em conta, sempre que for setado um novo saldo
    private void updateScoreCredito(){
        this.score_credito = this.saldo_cc * 0.1f;
    }

    // Persiste o valor de score_credito sempre que o saldo for alterado
    @PrePersist
    @PreUpdate
    public void persistAndUpdate(){
        updateScoreCredito();
    }
}
