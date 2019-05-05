package com.stage.safezone.model;

import com.stage.safezone.model.enums.SituacaoSolicitacao;

import javax.persistence.*;

@Entity
@Table(name = "SOLICITACOES_INGRESSO")
@SequenceGenerator(name = "SEQ_SOLICITACOES_INGRESSO", sequenceName = "SEQ_SOLICITACOES_INGRESSO", allocationSize = 1)
public class SolicitacaoIngresso implements Entidade {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_SOLICITACOES_INGRESSO", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "I_USUARIO")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "I_TIME")
    private Time time;

    @Column(name = "SITUACAO")
    private SituacaoSolicitacao situacao;

    @OneToOne
    @JoinColumn(name = "I_OPERADOR")
    private Operador operador;

    public SolicitacaoIngresso() {
    }

    public SolicitacaoIngresso(Usuario usuario, Time time, SituacaoSolicitacao situacaoSolicitacao, Operador operador) {
        this.usuario = usuario;
        this.time = time;
        this.situacao = situacaoSolicitacao;
        this.operador = operador;
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

    public SituacaoSolicitacao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoSolicitacao situacao) {
        this.situacao = situacao;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }
}
