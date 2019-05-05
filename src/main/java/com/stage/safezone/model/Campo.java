package com.stage.safezone.model;

import javax.persistence.*;

@Entity
@Table(name = "CAMPOS")
@SequenceGenerator(name = "SEQ_CAMPOS", sequenceName = "SEQ_CAMPOS", allocationSize = 1)
public class Campo implements ContextoUsuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_CAMPOS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "I_USUARIO")
    private Usuario usuario;

    public Campo() {
    }

    public Campo(Long id, String nome, String descricao, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
