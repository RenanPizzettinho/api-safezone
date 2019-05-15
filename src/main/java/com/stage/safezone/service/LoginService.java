package com.stage.safezone.service;

import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void logar(final Usuario usuario) {
//        final String passwordSecure = this.usuarioService.passwordSecure(usuario.getPassword());
//        final Usuario byUsuario = this.usuarioRepository.findByUsuario(usuario.getUsername());
//        if (byUsuario == null) {
//            throw new LoginException("Usuário " + usuario.getUsername() + " não encontrado");
//        }
//        if (passwordSecure.equals(byUsuario.getPassword())) {
//            return new Sessao(byUsuario, this.generateToken(usuario.getUsername()));
//        }
//        throw new LoginException("Senha incorreta");
    }

    public String generateToken(final String usuario) {
//        SecretKey secretKey = Keys.hmacShaKeyFor("MInhaMErdaDeChaveSecretaDosInferno".getBytes());
//        String token = Jwts.builder().setSubject(usuario)
//                .setIssuedAt(new Date())
//                .setExpiration(
//                        Date.from(LocalDateTime.now()
//                                .plusMinutes(60L)
//                                .atZone(ZoneId.systemDefault())
//                                .toInstant()))
//                .signWith(secretKey)
//                .compact();
//        return "Bearer ".concat(token);
        return null;
    }

}
