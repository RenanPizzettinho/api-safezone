package com.stage.safezone.specification;

import com.stage.safezone.model.QUsuario;
import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioSpecification implements Validate<Usuario> {

    private final Validator validator;
    private final BasicRepository repository;

    @Autowired
    public UsuarioSpecification(final Validator validator, final BasicRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    @Override
    public void validate(final Usuario entidade) {
        this.validator.validate(entidade, this.checkUsernameDuplicado(this.repository));
    }

    private Specification<Usuario> checkUsernameDuplicado(final BasicRepository repository) {
        return new Specification<Usuario>() {
            @Override
            protected boolean validate(final Usuario entidade) {
                this.setMensagem(String.format("Já exite um usuário com login %s cadastrado", entidade.getUsername()));

                return repository.query(Usuario.class)
                        .where(QUsuario.usuario.username.eq(entidade.getUsername()))
                        .fetchCount() == 0;
            }
        };
    }

}
