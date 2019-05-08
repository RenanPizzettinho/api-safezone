package com.stage.safezone.service;

import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.repository.UsuarioRepository;
import com.stage.safezone.util.UsuarioContext;
import com.stage.safezone.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements CrudService<Usuario> {

    private final BasicRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioContext usuarioContext;

    @Autowired
    public UsuarioService(final BasicRepository repository, final UsuarioRepository usuarioRepository, final UsuarioContext usuarioContext) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.usuarioContext = usuarioContext;
    }

    public Usuario save(final Usuario usuario) {
        usuario.setSenha(this.passwordSecure(usuario.getSenha()));
        return this.repository.save(Usuario.class, usuario);
    }

    @Override
    public Usuario find(final Long id) {
        return this.repository.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        return this.repository.findAll(Usuario.class);
    }

    @Override
    public void delete(final Long id) {
        this.repository.delete(Usuario.class, id);
    }

    public UsuarioVO update(final Usuario usuario) {
        final Usuario usuarioContexto = this.usuarioContexto();
        final String senha = usuario.getSenha();
        if (senha != null) {
            usuarioContexto.setSenha(this.passwordSecure(senha));
        }
        usuarioContexto.setNome(usuario.getNome());
        usuarioContexto.setUsuario(usuario.getUsuario());
        usuarioContexto.setEmail(usuario.getEmail());

        final Usuario save = this.repository.save(Usuario.class, usuarioContexto);
        return new UsuarioVO(save);

    }

    public UsuarioVO eu() {
        final String usuario = this.usuarioContext.getUsuario();
        final Usuario byUsuario = this.usuarioRepository.findByUsuario(usuario);

        return new UsuarioVO(byUsuario);

    }

    public Usuario usuarioContexto() {
        final String usuario = this.usuarioContext.getUsuario();
        return this.usuarioRepository.findByUsuario(usuario);
    }


    private String passwordSecure(final String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
