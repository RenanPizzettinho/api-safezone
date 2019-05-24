package com.stage.safezone.specification;

import com.stage.safezone.model.Entidade;

public interface Validate<T extends Entidade> {

    void validate(T entidade);

}
