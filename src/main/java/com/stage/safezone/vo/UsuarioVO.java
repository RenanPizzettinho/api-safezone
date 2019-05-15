package com.stage.safezone.vo;

import com.stage.safezone.model.Usuario;

public class UsuarioVO {

    private Long id;
    private String usuario;
    private String nome;
    private String email;

    public UsuarioVO() {
    }

    public UsuarioVO(Long id, String usuario, String nome, String email) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
    }

    public UsuarioVO(Usuario usuario) {
        this.id = usuario.getId();
        this.usuario = usuario.getUsername();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
