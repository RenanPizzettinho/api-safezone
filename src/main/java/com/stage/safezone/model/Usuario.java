package com.stage.safezone.model;

import javax.persistence.*;

@Entity
@Table(name = "USUARIOS")
@SequenceGenerator(name = "SEQ_USUARIOS", sequenceName = "SEQ_USUARIOS", allocationSize = 1)
public class Usuario implements Entidade {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_USUARIOS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "USUARIO", unique = true)
    private String usuario;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    public Usuario() {
    }

    public Usuario(Long id, String usuario, String nome, String email, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}