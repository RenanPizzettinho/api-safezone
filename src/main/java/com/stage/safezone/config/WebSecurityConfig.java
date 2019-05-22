package com.stage.safezone.config;

import com.stage.safezone.auth.JWTAuthenticationFilter;
import com.stage.safezone.auth.JWTLoginFilter;
import com.stage.safezone.auth.TokenAuthenticationService;
import com.stage.safezone.auth.UserDetaisService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetaisService userDetaisService;
    private final TokenAuthenticationService tokenAuthenticationService;

    public WebSecurityConfig(final UserDetaisService userDetaisService, final TokenAuthenticationService tokenAuthenticationService) {
        this.userDetaisService = userDetaisService;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/usuarios").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JWTLoginFilter("/login", this.authenticationManager(), this.tokenAuthenticationService),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(this.tokenAuthenticationService), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetaisService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


}

