package com.stage.safezone.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.PathBuilderFactory;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import com.stage.safezone.model.Entidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class BasicRepository {

    @Autowired
    private EntityManager em;

    public BasicRepository(EntityManager em) {
        this.em = em;
    }

    public <T extends Entidade> T save(final Class<T> clazz, final T bean) {
        if (bean.getId() != null) {
            final T oldBean = this.em.find(clazz, bean.getId());
            this.checkNotFound(oldBean);

            return this.em.merge(bean);

        } else {
            this.em.persist(bean);

            return bean;

        }
    }

    public <T extends Entidade> void delete(final Class<T> clazz, final Long id) {
        final T reference = this.em.getReference(clazz, id);
        this.checkNotFound(reference);
        this.em.remove(reference);
    }

    public <T extends Entidade> T find(final Class<T> clazz, final Long id) {
        final T bean = this.em.find(clazz, id);
        this.checkNotFound(bean);

        return bean;

    }

    public <T extends Entidade> List<T> findAll(final Class<T> clazz) {
        final PathBuilder<T> expr = new PathBuilderFactory().create(clazz);
        final JPAQuery select = new JPAQuery<T>(em).select(expr);

        return (List<T>) select.from(expr).fetch();

    }

    public <T extends Entidade> List<T> findAll(final Class<T> clazz, final Expression... expression) {
        final PathBuilder<T> expr = new PathBuilderFactory().create(clazz);
        final JPAQuery select = new JPAQuery<T>(em).select(expression);

        return (List<T>) select.from(expr).fetch();

    }

    public <T extends Entidade> JPAQueryBase query(final Class<T> clazz) {
        final PathBuilder<T> expr = new PathBuilderFactory().create(clazz);
        final JPAQuery select = new JPAQuery<T>(em).select(expr);

        return select.from(expr);

    }

    public <T extends Entidade> JPAQueryBase query(final Class<T> clazz, final Expression... expression) {
        final PathBuilder<T> expr = new PathBuilderFactory().create(clazz);
        final JPAQuery select = new JPAQuery<T>(em).select(expression);

        return select.from(expr);

    }

    protected <T extends Entidade> void checkNotFound(final T bean) {
        if (bean == null) {
            throw new EntityNotFoundException();
        }
    }

}
