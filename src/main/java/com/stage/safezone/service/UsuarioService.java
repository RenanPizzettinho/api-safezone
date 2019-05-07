package com.stage.safezone.service;

import com.stage.safezone.exception.LoginException;
import com.stage.safezone.model.Sessao;
import com.stage.safezone.model.Usuario;
import com.stage.safezone.repository.BasicRepository;
import com.stage.safezone.repository.UsuarioRepository;
import com.stage.safezone.util.UsuarioContext;
import com.stage.safezone.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        return repository.save(Usuario.class, usuario);
    }

    @Override
    public Usuario find(Long id) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

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

        final Usuario save = repository.save(Usuario.class, usuarioContexto);
        return new UsuarioVO(save);

    }

    public UsuarioVO eu() {
        final String usuario = usuarioContext.getUsuario();
        final Usuario byUsuario = usuarioRepository.findByUsuario(usuario);

        return new UsuarioVO(byUsuario);

    }

    public Usuario usuarioContexto() {
        final String usuario = usuarioContext.getUsuario();
        return usuarioRepository.findByUsuario(usuario);
    }

    public Sessao logar(final Usuario usuario) {
        final String passwordSecure = this.passwordSecure(usuario.getSenha());
        final Usuario byUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());
        if (byUsuario == null) {
            throw new LoginException("Usuário " + usuario.getUsuario() + " não encontrado");
        }
        if (passwordSecure.equals(byUsuario.getSenha())) {
            return new Sessao(byUsuario, this.generateToken(usuario.getUsuario()));
        }
        throw new LoginException("Senha incorreta");
    }

    public String generateToken(final String usuario) {
//        SecretKey secretKey = Keys.hmacShaKeyFor("MInhaMErdaDeChaveSecretaDosInferno".getBytes());
//        String token = Jwts.builder().setSubject(usuario)
//                .setIssuedAt(new Date())
//                .setExpiration(
//                        Date.from(LocalDateTime.now()
//                                .plusMinutes(60L)
//                                .atZone(ZoneId.systemDefault())
//                                .toInstant()))
//                .signWith(secretKey)
//                .compact();
//        return "Bearer ".concat(token);
        return null;
    }

    private String passwordSecure(final String senha) {
        MessageDigest md5;
        final StringBuilder sb = new StringBuilder();
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(senha.getBytes());
            for (byte aByte : md5.digest()) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sb.toString();

    }

}
