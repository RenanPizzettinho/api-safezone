package com.stage.safezone.specification;


import com.stage.safezone.model.Entidade;

public interface Specification<T extends Entidade> {

    void validate(T entidade);

}
