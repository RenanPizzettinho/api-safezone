package com.stage.safezone.service;

import com.stage.safezone.model.Operador;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadorService implements CrudService<Operador> {

    @Autowired
    private BasicRepository repository;

    @Autowired
    private OperadorRepository operadorRepository;

    public Operador save(Operador operador) {
        return repository.save(Operador.class, operador);
    }

    @Override
    public Operador find(Long id) {
        return null;
    }

    @Override
    public List<Operador> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public Integer getMaxIdentificadorPorTime(Long timeId) {
//        Integer max = operadorRepository.query()
//                .selectFrom(operador)
//                .select(operador.identificador.max())
//                .where(operador.time.id.eq(timeId))
//                .fetchFirst();
//
//        if (max == null) {
//            max = 0;
//        }
//
//        return max + 1;

        return 0;
    }

    public List<Operador> porTime(Long id) {
//        return operadorRepository.query()
//                .selectFrom(operador)
//                .where(operador.time.id.eq(id))
//                .fetch();
        return null;
    }
}
