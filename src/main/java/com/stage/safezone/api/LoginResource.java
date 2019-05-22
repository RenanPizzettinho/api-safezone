package com.stage.safezone.api;

import com.stage.safezone.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginResource {

    @PostMapping
    public ResponseEntity login(final Usuario usuario) {
        return ResponseEntity.ok(usuario);
    }

}
