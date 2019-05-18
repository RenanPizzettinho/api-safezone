package com.stage.safezone.repository;

import com.stage.safezone.model.QUsuario;
import com.stage.safezone.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.stage.safezone.model.QUsuario.usuario;

@Repository
public class UsuarioRepository {

    @Autowired
    private BasicRepository repository;

    public Usuario findByUsuario(final String username) {
        return this.repository.query()
                .select(QUsuario.usuario)
                .from(usuario)
                .where(usuario.username.eq(username))
                .fetchOne();
    }

}
