package com.stage.safezone.service;

import com.stage.safezone.model.Time;
import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.stage.safezone.model.QTime.time;

@Service
public class TimeService implements CrudService<Time> {

    @Autowired
    private BasicRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Time save(final Time time) {
        return this.repository.save(Time.class, time);
    }

    @Override
    public Time find(final Long id) {
        return this.repository.find(Time.class, id);
    }

    @Override
    public List<Time> findAll() {
        return this.repository.findAll(Time.class);
    }

    @Override
    public void delete(final Long id) {
        this.repository.delete(Time.class, id);
    }

    public List<Time> meuTime() {
        final Usuario usuario = this.usuarioService.usuarioContexto();
        return this.repository.query()
                .select(time)
                .where(time.usuario.id.eq(usuario.getId()))
                .fetchResults()
                .getResults();
    }
}
