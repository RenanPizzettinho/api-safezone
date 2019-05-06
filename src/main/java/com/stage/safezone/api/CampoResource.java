package com.stage.safezone.api;

import com.stage.safezone.model.Campo;
import com.stage.safezone.service.CampoService;
import com.stage.safezone.util.UsuarioContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("campos")
public class CampoResource {

    @Autowired
    private CampoService campoService;

    @Autowired
    private UsuarioContext usuarioContext;

    @PostMapping
    public ResponseEntity create(final Campo campo) {
        usuarioContext.getUsuario();
        return ResponseEntity.ok(campoService.save(campo));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(campoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathParam("id") Long id) {
        return ResponseEntity.ok(campoService.find(id));
    }

}
