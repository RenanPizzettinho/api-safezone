package com.stage.safezone.api;

import com.stage.safezone.model.Usuario;
import com.stage.safezone.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity oi(Usuario usuario) {
        return ResponseEntity.ok("oi");
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @GetMapping("login")
    public ResponseEntity findOne() {
        return ResponseEntity.ok(usuarioService.eu());
    }

}
