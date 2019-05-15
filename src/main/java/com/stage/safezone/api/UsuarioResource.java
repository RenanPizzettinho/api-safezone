package com.stage.safezone.api;

import com.stage.safezone.model.Usuario;
import com.stage.safezone.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody final Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @GetMapping("login")
    public ResponseEntity findOne() {
        return ResponseEntity.ok(usuarioService.eu());
    }

}
