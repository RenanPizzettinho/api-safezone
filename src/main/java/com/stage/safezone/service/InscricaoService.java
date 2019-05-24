package com.stage.safezone.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.stage.safezone.model.Evento;
import com.stage.safezone.model.Inscricao;
import com.stage.safezone.model.Usuario;
import com.stage.safezone.model.enums.InscricaoStatus;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.repository.ContextoUsuarioRepository;
import com.stage.safezone.specification.InscricaoSpecification;
import com.stage.safezone.specification.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.stage.safezone.model.QInscricao.inscricao;
import static com.stage.safezone.model.enums.InscricaoStatus.CONFIRMADO;
import static com.stage.safezone.model.enums.InscricaoStatus.PENDENTE;

@Service
public class InscricaoService implements CrudService<Inscricao> {

    private final BasicRepository repository;
    private final ContextoUsuarioRepository contextoUsuarioRepository;
    private final EventoService eventoService;
    private final UsuarioService usuarioService;
    private final Validator validator;

    @Autowired
    public InscricaoService(final BasicRepository repository, final ContextoUsuarioRepository contextoUsuarioRepository, final EventoService eventoService, final UsuarioService usuarioService, final Validator validator) {
        this.repository = repository;
        this.contextoUsuarioRepository = contextoUsuarioRepository;
        this.eventoService = eventoService;
        this.usuarioService = usuarioService;
        this.validator = validator;
    }

    @Override
    public Inscricao save(final Inscricao inscricao) {
        return this.repository.save(Inscricao.class, inscricao);
    }

    @Override
    public Inscricao find(final Long id) {
        return this.repository.find(Inscricao.class, id);
    }

    @Override
    public List<Inscricao> findAll() {
        return this.repository.findAll(Inscricao.class);
    }

    @Override
    public void delete(final Long id) {
        this.repository.delete(Inscricao.class, id);
    }

    public Inscricao inscrever(final Long idEvento) {
        final Evento evento = this.eventoService.find(idEvento);
        final Inscricao inscricaoNova = new Inscricao(evento, PENDENTE, this.usuarioService.usuarioContexto());
        new InscricaoSpecification(this.repository, this.validator).validate(inscricaoNova);

        return this.contextoUsuarioRepository.saveWithContext(Inscricao.class, inscricaoNova);

    }

    public Inscricao cancelar(final Long idInscricao) {
        this.mudarStatus(idInscricao, InscricaoStatus.CANCELADO);
        return this.find(idInscricao);
    }

    public Inscricao confirmar(final Long idInscricao) {
        this.mudarStatus(idInscricao, CONFIRMADO);
        return this.find(idInscricao);
    }

    public List<Inscricao> findByUsuario(Long usuarioId) {
        if (usuarioId == null) {
            final Usuario usuario = this.usuarioService.usuarioContexto();
            usuarioId = usuario.getId();
        }
        final JPAQuery<Inscricao> where = this.repository.query(Inscricao.class)
                .where(inscricao.usuario.id.eq(usuarioId));

        return where.fetch();

    }

    public List<Inscricao> findByEvento(final Long eventoId) {
        final JPAQuery<Inscricao> where = this.repository.query(Inscricao.class)
                .where(inscricao.evento.id.eq(eventoId));

        return where.fetch();

    }

    private void mudarStatus(final Long idInscricao, final InscricaoStatus status) {
        this.repository.update(Inscricao.class)
                .set(inscricao.status, status)
                .where(inscricao.id.eq(idInscricao))
                .execute();
    }


}
