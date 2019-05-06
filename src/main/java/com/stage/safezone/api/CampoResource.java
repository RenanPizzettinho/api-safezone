package com.stage.safezone.api;

import com.stage.safezone.model.Campo;
import com.stage.safezone.service.CampoService;
import com.stage.safezone.util.UsuarioContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(campoService.find(id));
    }

}
