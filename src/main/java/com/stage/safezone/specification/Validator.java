package com.stage.safezone.specification;

import com.stage.safezone.exception.ValidationException;
import com.stage.safezone.model.Entidade;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public <T extends Entidade> void validate(final T entidade, final Specification<T>... specifications) {

        for (final Specification<T> specification : specifications) {
            this.validate(entidade, specification);
        }

    }

    private <T extends Entidade> void validate(final T entidade, final Specification<T> specification) {
        if (!specification.validate(entidade)) {
            throw new ValidationException(specification.getMensagem());
        }
    }

}
