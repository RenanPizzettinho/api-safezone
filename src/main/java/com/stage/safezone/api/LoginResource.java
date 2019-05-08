package com.stage.safezone.api;

import com.stage.safezone.model.Usuario;
import com.stage.safezone.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity login(Usuario usuario) {
//        return ResponseEntity.ok(this.loginService.logar(usuario));
        return ResponseEntity.ok().build();
    }

}
