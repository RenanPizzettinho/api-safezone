package com.stage.safezone.api;

import com.stage.safezone.model.Operador;
import com.stage.safezone.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("operadores")
public class OperadorResource {

    @Autowired
    private OperadorService operadorService;

    @GetMapping("time/{id}")
    public ResponseEntity porTime(@PathVariable("id") final Long id) {
        List<Operador> operadores = operadorService.porTime(id);
        return ResponseEntity.ok(operadores);
    }

}
