package com.stage.safezone.api;


import com.stage.safezone.model.SolicitacaoIngresso;
import com.stage.safezone.service.SolicitacaoIngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("solicitar-ingresso")
public class SolicitacaoIngressoTimeResource {

    private final SolicitacaoIngressoService solicitacaoIngressoService;

    @Autowired
    public SolicitacaoIngressoTimeResource(final SolicitacaoIngressoService solicitacaoIngressoService) {
        this.solicitacaoIngressoService = solicitacaoIngressoService;
    }

    @PostMapping("time/{id}/solicitar")
    public ResponseEntity solicitar(@PathVariable("id") final Long id) {
        final SolicitacaoIngresso solicitacaoIngresso = solicitacaoIngressoService.solicitar(id);
        return ResponseEntity.ok(solicitacaoIngresso);
    }

    @PutMapping("{id}/aprovar")
    public ResponseEntity aprovar(@PathVariable("id") final Long id) {
        final SolicitacaoIngresso aprovar = solicitacaoIngressoService.aprovar(id);
        return ResponseEntity.ok(aprovar);
    }

    @PutMapping("{id}/negar")
    public ResponseEntity negar(@PathVariable("id") final Long id) {
        final SolicitacaoIngresso aprovar = solicitacaoIngressoService.negar(id);
        return ResponseEntity.ok(aprovar);
    }

    @GetMapping("time/{id}")
    public ResponseEntity porTime(@PathVariable("id") final Long id) {
        final List<SolicitacaoIngresso> solicitacaoIngressos = solicitacaoIngressoService.porTime(id);
        return ResponseEntity.ok(solicitacaoIngressos);
    }

    @GetMapping("minhas")
    public ResponseEntity minhas() {
        final List<SolicitacaoIngresso> solicitacaoIngressos = solicitacaoIngressoService.minhas();
        return ResponseEntity.ok(solicitacaoIngressos);
    }

}
