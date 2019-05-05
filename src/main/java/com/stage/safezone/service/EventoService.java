package com.stage.safezone.service;

import com.stage.safezone.model.Evento;
import com.stage.safezone.model.enums.SituacaoEvento;
import com.stage.safezone.repository.ContextoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService implements CrudService<Evento> {

    @Autowired
    private ContextoUsuarioRepository repository;

    public Evento save(Evento evento) {

        if (evento.getId() == null && evento.getSituacaoEvento() == null) {
            evento.setSituacaoEvento(SituacaoEvento.EM_ABERTO);
        }
        return repository.saveWithContext(Evento.class, evento);

    }

    @Override
    public Evento find(Long id) {
        return null;
    }

    @Override
    public List<Evento> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
