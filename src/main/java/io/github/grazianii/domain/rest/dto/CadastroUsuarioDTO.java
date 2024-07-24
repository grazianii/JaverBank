package io.github.grazianii.domain.rest.dto;

import io.github.grazianii.domain.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class CadastroUsuarioDTO {

    private Usuario usuario;
    private List<String> permissao;
}