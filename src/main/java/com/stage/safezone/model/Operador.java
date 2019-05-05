package com.stage.safezone.model;

import com.stage.safezone.model.enums.SituacaoOperador;

import javax.persistence.*;

@Entity
@Table(name = "OPERADORES")
@SequenceGenerator(name = "SEQ_OPERADORES", sequenceName = "SEQ_OPERADORES", allocationSize = 1)
public class Operador implements Entidade {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_OPERADORES", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "I_USUARIO")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "I_TIME")
    private Time time;

    @Column(name = "IDENTIFICADOR")
    private Integer identificador;

    @Column(name = "SITUACAO")
    private SituacaoOperador situacaoOperador;

    public Operador() {
    }

    public Operador(Usuario usuario, Time time, Integer identificador, SituacaoOperador situacaoOperador) {
        this.usuario = usuario;
        this.time = time;
        this.identificador = identificador;
        this.situacaoOperador = situacaoOperador;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public SituacaoOperador getSituacaoOperador() {
        return situacaoOperador;
    }

    public void setSituacaoOperador(SituacaoOperador situacaoOperador) {
        this.situacaoOperador = situacaoOperador;
    }
}
