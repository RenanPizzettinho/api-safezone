package com.stage.safezone.api;

import com.stage.safezone.model.Evento;
import com.stage.safezone.service.EventoService;
import com.stage.safezone.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eventos")
public class EventoResource {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping
    public ResponseEntity create(final Evento evento) {
        return ResponseEntity.ok(eventoService.save(evento));
    }

    @GetMapping
    public List<Evento> findAll() {
        return eventoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventoService.find(id));
    }

}
