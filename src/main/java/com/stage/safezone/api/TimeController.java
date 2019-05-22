package com.stage.safezone.api;

import com.stage.safezone.model.Time;
import com.stage.safezone.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("times")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(final TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public List<Time> findAll() {
        return this.timeService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Time> find(@PathVariable("id") final Long id) {
        final Time time = this.timeService.find(id);
        return ResponseEntity.ok(time);
    }

    @PostMapping
    public ResponseEntity<Time> create(@RequestBody final Time time) {
        final Time save = this.timeService.save(time);
        return ResponseEntity.ok(save);
    }

    @PutMapping
    public ResponseEntity<Time> update(@RequestBody final Time time) {
        final Time save = this.timeService.save(time);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/meu")
    public ResponseEntity meusTime() {
        final List<Time> times = this.timeService.meuTime();
        return ResponseEntity.ok(times);
    }

}
