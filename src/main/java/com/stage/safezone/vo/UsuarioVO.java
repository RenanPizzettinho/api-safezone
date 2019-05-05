package com.stage.safezone.vo;

import com.stage.safezone.model.Usuario;

public class UsuarioVO {

    private Long id;
    private String usuario;
    private String nome;
    private String email;

    public UsuarioVO(Usuario usuario) {
        this.id = usuario.getId();
        this.usuario = usuario.getUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
