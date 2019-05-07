package com.stage.safezone.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.stage.safezone.model.Operador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.stage.safezone.model.QOperador.operador;

@Repository
public class OperadorRepository {

    @Autowired
    private BasicRepository repository;

    public Operador byUsuarioId(final Long id) {
        return this.repository.query()
                .select(operador)
                .from(operador)
                .where(operador.usuario.id.eq(id))
                .fetchOne();
    }

    public Integer getMaxIdentificador(final BooleanExpression where) {
        return this.repository.query()
                .select(operador.identificador.max())
                .from(operador)
                .where(where)
                .fetchFirst();
    }

}
