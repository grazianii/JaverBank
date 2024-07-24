package io.github.grazianii.domain.rest.controller;

import io.github.grazianii.domain.entity.Usuario;
import io.github.grazianii.domain.rest.dto.CadastroUsuarioDTO;
import io.github.grazianii.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Usuario> save (@RequestBody CadastroUsuarioDTO cadastroUsuarioDTO){
        Usuario usuarioSalvo = usuarioService.save(cadastroUsuarioDTO.getUsuario(), cadastroUsuarioDTO.getPermissao());
        return ResponseEntity.ok(usuarioSalvo);
    }
}