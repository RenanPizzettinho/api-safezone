package com.stage.safezone.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JWTLoginFilter(final String defaultFilterProcessesUrl, final AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManager);

    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse httpServletResponse) throws AuthenticationException, IOException {
        final AccountCredentials credentials = new ObjectMapper().readValue(request.getInputStream(), AccountCredentials.class);
        final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(credentials.getUsuario(), credentials.getSenha(), Collections.emptyList());
        return getAuthenticationManager().authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain, final Authentication authResult) {
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
    }
}
