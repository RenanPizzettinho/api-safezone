package com.stage.safezone.api;

import com.stage.safezone.model.Inscricao;
import com.stage.safezone.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("inscricoes")
public class InscricaoResource {

    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping("usuario/{id}")
    public ResponseEntity findByUsuario(@PathParam("id") final Long id) {

        List<Inscricao> byUsuario = inscricaoService.findByUsuario(id);

        return ResponseEntity.ok(byUsuario);
    }

    @GetMapping("evento/{id}")
    public ResponseEntity findByEvento(@PathParam("id") final Long id) {

        List<Inscricao> byEvento = inscricaoService.findByEvento(id);

        return ResponseEntity.ok(byEvento);
    }

    @PostMapping("evento/{id}/me-inscrever")
    public ResponseEntity inscrever(@PathParam("id") Long id) {
        return ResponseEntity.ok(inscricaoService.inscrever(id));
    }

    @PutMapping("{id}/cancelar")
    public ResponseEntity cancelar(@PathParam("id") final Long id) {
        Inscricao cancelar = inscricaoService.cancelar(id);
        return ResponseEntity.ok(cancelar);
    }

    @PutMapping("{id}/confirmar")
    public ResponseEntity confirmar(@PathParam("id") final Long id) {
        Inscricao confirmar = inscricaoService.confirmar(id);
        return ResponseEntity.ok(confirmar);
    }

}
