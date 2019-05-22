package com.stage.safezone.auth;

import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

@Service
public class TokenAuthenticationService {

    @Value("${defaut.secret}")
    private String SECRET;
    private final long EXPIRATION_TIME = 360000;
    private final String TOKEN_PREFIX = "Bearer ";
    private final String HEADER_STRING = "Authorization";
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public TokenAuthenticationService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public void addAuthentication(final HttpServletResponse response, final String userName) {
        final String token = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }

    public Authentication getAuthentication(final HttpServletRequest request) {
        final String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            final String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                final Usuario usuario = this.usuarioRepository.findByUsuario(user);
                return new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());
            }
        }
        return null;
    }

}
