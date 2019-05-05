package com.stage.safezone.model;

import com.stage.safezone.model.enums.SituacaoEvento;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "EVENTOS")
@SequenceGenerator(name = "SEQ_EVENTOS", sequenceName = "SEQ_EVENTOS", allocationSize = 1)
public class Evento implements ContextoUsuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_EVENTOS", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(name = "TITULO")
    private String titulo;

    @NotNull
    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA")
    private LocalDate data;

    @Column(name = "HR_INICIO")
    private LocalDateTime horaInicio;

    @Column(name = "SITUACAO", length = 1)
    private SituacaoEvento situacaoEvento;

    @Column(name = "PAGO")
    private Boolean pago = false;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "LIMITE_OPR")
    private Boolean limiteOperadores = false;

    @Column(name = "QTD_LIMITE_OPR")
    private Integer quantidadeLimiteOperadores;

    @Column(name = "CRONAGEM")
    private Boolean cronagem = false;

    @Column(name = "HR_INICIO_CRONAGEM")
    private LocalDateTime horaInicioCronagem;

    @OneToOne
    @JoinColumn(name = "I_USUARIO")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "I_CAMPO")
    private Campo campo;

    @OneToOne
    @JoinColumn(name = "I_TIME")
    private Time timeResponsavel;

    public Evento() {
    }

    public Evento(Long id, @NotNull String titulo, @NotNull String descricao, LocalDate data, LocalDateTime horaInicio, SituacaoEvento situacaoEvento, Boolean pago, Double valor, Boolean limiteOperadores, Integer quantidadeLimiteOperadores, Boolean cronagem, LocalDateTime horaInicioCronagem, Usuario usuario, Campo campo, Time timeResponsavel) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.horaInicio = horaInicio;
        this.situacaoEvento = situacaoEvento;
        this.pago = pago;
        this.valor = valor;
        this.limiteOperadores = limiteOperadores;
        this.quantidadeLimiteOperadores = quantidadeLimiteOperadores;
        this.cronagem = cronagem;
        this.horaInicioCronagem = horaInicioCronagem;
        this.usuario = usuario;
        this.campo = campo;
        this.timeResponsavel = timeResponsavel;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public SituacaoEvento getSituacaoEvento() {
        return situacaoEvento;
    }

    public void setSituacaoEvento(SituacaoEvento situacaoEvento) {
        this.situacaoEvento = situacaoEvento;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getLimiteOperadores() {
        return limiteOperadores;
    }

    public void setLimiteOperadores(Boolean limiteOperadores) {
        this.limiteOperadores = limiteOperadores;
    }

    public Integer getQuantidadeLimiteOperadores() {
        return quantidadeLimiteOperadores;
    }

    public void setQuantidadeLimiteOperadores(Integer quantidadeLimiteOperadores) {
        this.quantidadeLimiteOperadores = quantidadeLimiteOperadores;
    }

    public Boolean getCronagem() {
        return cronagem;
    }

    public void setCronagem(Boolean cronagem) {
        this.cronagem = cronagem;
    }

    public LocalDateTime getHoraInicioCronagem() {
        return horaInicioCronagem;
    }

    public void setHoraInicioCronagem(LocalDateTime horaInicioCronagem) {
        this.horaInicioCronagem = horaInicioCronagem;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public Time getTimeResponsavel() {
        return timeResponsavel;
    }

    public void setTimeResponsavel(Time timeResponsavel) {
        this.timeResponsavel = timeResponsavel;
    }
}
