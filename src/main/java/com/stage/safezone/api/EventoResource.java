package com.stage.safezone.api;

import com.stage.safezone.model.Evento;
import com.stage.safezone.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("evento")
public class EventoResource {

    private final EventoService eventoService;

    @Autowired
    public EventoResource(final EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity create(final Evento evento) {
        return ResponseEntity.ok(eventoService.save(evento));
    }

    @GetMapping
    public List<Evento> findAll() {
        return eventoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(eventoService.find(id));
    }

}
