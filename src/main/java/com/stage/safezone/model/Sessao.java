package com.stage.safezone.model;

public class Sessao {

    private String usuario;
    private String token;

    public Sessao() {
    }

    public Sessao(Usuario usuario, String token) {
        this.usuario = usuario.getUsuario();
        this.token = token;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
