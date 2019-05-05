package com.stage.safezone.util;


import org.springframework.stereotype.Component;

@Component
public class UsuarioContext {

    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
