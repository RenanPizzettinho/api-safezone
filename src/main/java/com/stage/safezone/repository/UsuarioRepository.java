package com.stage.safezone.repository;

import com.stage.safezone.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.stage.safezone.model.QUsuario.usuario1;

@Repository
public class UsuarioRepository {

    @Autowired
    private BasicRepository repository;

    public Usuario findByUsuario(final String usuario) {
        return this.repository.query()
                .select(usuario1)
                .from(usuario1)
                .where(usuario1.usuario.eq(usuario))
                .fetchOne();
    }

}
