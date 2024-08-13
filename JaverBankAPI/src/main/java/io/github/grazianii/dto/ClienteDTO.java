package io.github.grazianii.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    @NotNull (message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotNull (message = "{campo.cpf.obrigatorio}")
    private String cpf;

    @NotNull (message = "{campo.telefone.obrigatorio}")
    private long telefone;

    @NotNull (message = "{campo.saldo_cc.obrigatorio}")
    private float saldo_cc;

    @JsonIgnore
    private float score_credito;

    @NotNull (message = "{campo.correntista.obrigatorio}")
    private boolean correntista;
}
