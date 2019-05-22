package com.stage.safezone.repository;


import com.stage.safezone.exception.UsuarioNaoProprietarioException;
import com.stage.safezone.model.ContextoUsuario;
import com.stage.safezone.model.Usuario;
import com.stage.safezone.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class ContextoUsuarioRepository {

    private final BasicRepository repository;
    private final UsuarioService usuarioService;

    @Autowired
    public ContextoUsuarioRepository(final BasicRepository repository, final UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    public <T extends ContextoUsuario> T saveWithContext(final Class<T> clazz, final T bean) {
        if (bean.getId() == null) {
            bean.setUsuario(this.usuarioService.usuarioContexto());

            return this.repository.save(clazz, bean);

        }
        final T oldBean = this.repository.find(clazz, bean.getId());
        this.repository.checkNotFound(oldBean);
        this.checkUsuario(oldBean);

        return this.repository.save(clazz, bean);

    }


    private <T extends ContextoUsuario> void checkUsuario(final T bean) {
        final Usuario usuarioContexto = this.usuarioService.usuarioContexto();
        if (!Objects.equals(bean.getUsuario().getId(), usuarioContexto.getId())) {
            throw new UsuarioNaoProprietarioException();
        }
    }

}
