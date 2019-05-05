package com.stage.safezone.service;

import com.stage.safezone.model.Evento;
import com.stage.safezone.model.Inscricao;
import com.stage.safezone.model.Usuario;
import com.stage.safezone.model.enums.InscricaoStatus;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.repository.ContextoUsuarioRepository;
import com.stage.safezone.specification.InscricaoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.stage.safezone.model.enums.InscricaoStatus.CONFIRMADO;
import static com.stage.safezone.model.enums.InscricaoStatus.PENDENTE;

@Service
public class InscricaoService implements CrudService<Inscricao> {

    @Autowired
    private BasicRepository repository;

    @Autowired
    private ContextoUsuarioRepository contextoUsuarioRepository;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private UsuarioService usuarioService;

    public Inscricao save(Inscricao inscricao) {
        return repository.save(Inscricao.class, inscricao);
    }

    @Override
    public Inscricao find(Long id) {
        return null;
    }

    @Override
    public List<Inscricao> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public Inscricao inscrever(Long idEvento) {

        final Evento evento = eventoService.find(idEvento);
        final Inscricao inscricaoNova = new Inscricao(evento, PENDENTE, usuarioService.usuarioContexto());
        new InscricaoSpecification(contextoUsuarioRepository).validate(inscricaoNova);

        return contextoUsuarioRepository.saveWithContext(Inscricao.class, inscricaoNova);

    }

    public Inscricao cancelar(Long idInscricao) {

        this.mudarStatus(idInscricao, InscricaoStatus.CANCELADO);
        return this.find(idInscricao);

    }

    public Inscricao confirmar(Long idInscricao) {

        this.mudarStatus(idInscricao, CONFIRMADO);
        return this.find(idInscricao);

    }


    public List<Inscricao> findByUsuario(Long usuarioId) {

        if (usuarioId == null) {
            Usuario usuario = usuarioService.usuarioContexto();
            usuarioId = usuario.getId();
        }

//        return contextoUsuarioRepository.query()
//                .selectFrom(inscricao)
//                .where(inscricao.usuario.id.eq(usuarioId))
//                .fetch();
        return null;

    }

    public List<Inscricao> findByEvento(Long eventoId) {

//        return contextoUsuarioRepository.query()
//                .selectFrom(inscricao)
//                .where(inscricao.evento.id.eq(eventoId))
//                .fetch();

        return null;

    }

    private void mudarStatus(Long idInscricao, InscricaoStatus status) {
//        contextoUsuarioRepository.update(inscricao)
//                .set(inscricao.status, status)
//                .where(inscricao.id.eq(idInscricao))
//                .execute();
    }


}
