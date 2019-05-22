package com.stage.safezone.api;

import com.stage.safezone.model.Campo;
import com.stage.safezone.service.CampoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("campo")
public class CampoResource {

    private final CampoService campoService;

    @Autowired
    public CampoResource(final CampoService campoService) {
        this.campoService = campoService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody final Campo campo) {
        return ResponseEntity.ok(campoService.save(campo));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Campo campo) {
        return ResponseEntity.ok(campoService.save(campo));
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(campoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(campoService.find(id));
    }

}
