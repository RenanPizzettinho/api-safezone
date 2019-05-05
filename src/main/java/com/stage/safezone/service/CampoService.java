package com.stage.safezone.service;

import com.stage.safezone.model.Campo;
import com.stage.safezone.repository.ContextoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampoService implements CrudService<Campo> {

    @Autowired
    private ContextoUsuarioRepository repository;

    public Campo save(Campo campo) {
        return repository.saveWithContext(Campo.class, campo);
    }

    @Override
    public Campo find(Long id) {
        return null;
    }

    @Override
    public List<Campo> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }


}
