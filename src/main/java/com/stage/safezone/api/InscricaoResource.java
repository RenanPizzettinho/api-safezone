package com.stage.safezone.api;

import com.stage.safezone.model.Inscricao;
import com.stage.safezone.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inscricao")
public class InscricaoResource {

    private final InscricaoService inscricaoService;

    @Autowired
    public InscricaoResource(final InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @GetMapping("usuario/{id}")
    public ResponseEntity findByUsuario(@PathVariable("id") final Long id) {

        final List<Inscricao> byUsuario = this.inscricaoService.findByUsuario(id);

        return ResponseEntity.ok(byUsuario);
    }

    @GetMapping("evento/{id}")
    public ResponseEntity findByEvento(@PathVariable("id") final Long id) {

        final List<Inscricao> byEvento = this.inscricaoService.findByEvento(id);

        return ResponseEntity.ok(byEvento);
    }

    @PostMapping("evento/{id}/me-inscrever")
    public ResponseEntity inscrever(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(this.inscricaoService.inscrever(id));
    }

    @PutMapping("{id}/cancelar")
    public ResponseEntity cancelar(@PathVariable("id") final Long id) {
        final Inscricao cancelar = this.inscricaoService.cancelar(id);
        return ResponseEntity.ok(cancelar);
    }

    @PutMapping("{id}/confirmar")
    public ResponseEntity confirmar(@PathVariable("id") final Long id) {
        final Inscricao confirmar = this.inscricaoService.confirmar(id);
        return ResponseEntity.ok(confirmar);
    }

}
