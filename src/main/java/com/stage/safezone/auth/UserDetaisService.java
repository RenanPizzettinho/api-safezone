package com.stage.safezone.auth;

import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetaisService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final Usuario usuario = usuarioRepository.findByUsuario(userName);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario com o login " + userName + " não encontrado");
        }
        return usuario;
    }

}
