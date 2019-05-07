package com.stage.safezone.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.stage.safezone.model.Operador;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

import static com.stage.safezone.model.QOperador.operador;

@Service
public class OperadorService implements CrudService<Operador> {

    @Autowired
    private BasicRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private OperadorRepository operadorRepository;

    public Operador save(final Operador operador) {
        return repository.save(Operador.class, operador);
    }

    @Override
    public Operador find(final Long id) {
        return this.repository.find(Operador.class, id);
    }

    @Override
    public List<Operador> findAll() {
        return this.repository.findAll(Operador.class);
    }

    @Override
    public void delete(Long id) {
        repository.delete(Operador.class, id);
    }

    public Integer getMaxIdentificadorPorTime(Long timeId) {
        Integer max = this.operadorRepository.getMaxIdentificador(operador.time.id.eq(timeId));
        if (max == null) {
            max = 0;
        }

        return max + 1;

    }

    public List<Operador> porTime(Long id) {
        final JPAQuery<Operador> where = this.repository.query(Operador.class)
                .where(operador.time.id.eq(id));

        return where.fetch();

    }
}
