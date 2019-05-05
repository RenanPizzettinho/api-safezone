package com.stage.safezone.service;

import java.util.List;

public interface CrudService<T> {

    T save(final T t);

    T find(final Long id);

    List<T> findAll();

    void delete(final Long id);

}
