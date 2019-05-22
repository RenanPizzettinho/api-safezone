package com.stage.safezone.auth;

import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetaisService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetaisService(final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final Usuario usuario = this.usuarioRepository.findByUsuario(userName);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario com o login " + userName + " não encontrado");
        }
        return usuario;
    }

}
