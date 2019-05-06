package com.stage.safezone.service;

import com.stage.safezone.model.Campo;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.repository.ContextoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampoService implements CrudService<Campo> {

    private ContextoUsuarioRepository usuarioRepository;
    private BasicRepository repository;

    @Autowired
    public CampoService(ContextoUsuarioRepository usuarioRepository, BasicRepository repository) {
        this.usuarioRepository = usuarioRepository;
        this.repository = repository;
    }

    public Campo save(final Campo campo) {
        return usuarioRepository.saveWithContext(Campo.class, campo);
    }

    @Override
    public Campo find(final Long id) {
        return this.repository.find(Campo.class, id);
    }

    @Override
    public List<Campo> findAll() {
        return this.repository.findAll(Campo.class);
    }

    @Override
    public void delete(final Long id) {
        this.repository.delete(Campo.class, id);
    }

}
