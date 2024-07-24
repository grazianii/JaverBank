package io.github.grazianii.service;

import io.github.grazianii.domain.entity.Grupo;
import io.github.grazianii.domain.entity.Usuario;
import io.github.grazianii.domain.entity.UsuarioGrupo;
import io.github.grazianii.domain.repository.GrupoRepository;
import io.github.grazianii.domain.repository.UsuarioGrupoRepository;
import io.github.grazianii.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final GrupoRepository grupoRepository;
    private final UsuarioGrupoRepository usuarioGrupoRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario save(Usuario usuario, List<String> grupos) {
        String encryptedSenha = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encryptedSenha);
        usuarioRepository.save(usuario);

        List<UsuarioGrupo> listaUsuarioGrupo = grupos.stream()
                .map(nomeGrupo -> {
                    Optional<Grupo> possivelGrupo = grupoRepository.findByNome(nomeGrupo);
                    if (possivelGrupo.isPresent()) {
                        Grupo grupo = possivelGrupo.get();
                        return new UsuarioGrupo(usuario, grupo);
                    }
                    return null;
                })
                .filter(grupo -> grupo != null)
                .collect(Collectors.toList());

        usuarioGrupoRepository.saveAll(listaUsuarioGrupo);
        return usuario;
    }

    public Usuario givePermissaoToUsuario(String login) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByLogin(login);
        if (usuarioOptional.isEmpty()) {
            return null;
        }
        Usuario usuario = usuarioOptional.get();
        List<String> permissao = usuarioGrupoRepository.findPermissaoByUsuario(usuario);
        usuario.setPermissao(permissao);
        return usuario;
    }
}