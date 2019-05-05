package com.stage.safezone.model;

import com.stage.safezone.model.enums.InscricaoStatus;

import javax.persistence.*;

@Entity
@Table(name = "INSCRICOES")
@SequenceGenerator(name = "SEQ_INSCRICOES", sequenceName = "SEQ_INSCRICOES", allocationSize = 1)
public class Inscricao implements ContextoUsuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_INSCRICOES", strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    @JoinColumn(name = "I_EVENTOS")
    private Evento evento;

    @OneToOne
    @JoinColumn(name = "I_USUARIO")
    private Usuario usuario;

    @Column(name = "STATUS")
    private InscricaoStatus status;

    public Inscricao() {
    }

    public Inscricao(Evento evento, InscricaoStatus status, Usuario usuario) {
        this.evento = evento;
        this.status = status;
        this.usuario = usuario;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public InscricaoStatus getStatus() {
        return status;
    }

    public void setStatus(InscricaoStatus status) {
        this.status = status;
    }
}
