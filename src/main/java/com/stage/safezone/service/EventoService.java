package com.stage.safezone.service;

import com.stage.safezone.model.Evento;
import com.stage.safezone.model.enums.SituacaoEvento;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.repository.ContextoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService implements CrudService<Evento> {

    @Autowired
    private BasicRepository repository;

    @Autowired
    private ContextoUsuarioRepository contextoUsuarioRepository;

    public Evento save(Evento evento) {

        if (evento.getId() == null && evento.getSituacaoEvento() == null) {
            evento.setSituacaoEvento(SituacaoEvento.EM_ABERTO);
        }
        return contextoUsuarioRepository.saveWithContext(Evento.class, evento);

    }

    @Override
    public Evento find(final Long id) {
        return repository.find(Evento.class, id);
    }

    @Override
    public List<Evento> findAll() {
        return repository.findAll(Evento.class);
    }

    @Override
    public void delete(final Long id) {
        repository.delete(Evento.class, id);
    }

}
