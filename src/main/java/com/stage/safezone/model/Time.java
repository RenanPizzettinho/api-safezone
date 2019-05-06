package com.stage.safezone.model;

import javax.persistence.*;

@Entity
@Table(name = "TIMES")
@SequenceGenerator(name = "SEQ_TIMES", sequenceName = "SEQ_TIMES", allocationSize = 1)
public class Time implements ContextoUsuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_TIMES", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRE")
    private String sobre;

    @OneToOne
    @JoinColumn(name = "I_USUARIO")
    private Usuario usuario;

    public Time() {
    }

    public Time(Long id, String nome, String sobre) {
        this.id = id;
        this.nome = nome;
        this.sobre = sobre;
    }

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

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
