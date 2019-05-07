package com.stage.safezone.api;

import com.stage.safezone.model.Time;
import com.stage.safezone.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("times")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
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

    @GetMapping("/meu")
    public ResponseEntity meusTime() {
        final List<Time> times = timeService.meuTime();
        return ResponseEntity.ok(times);
    }

}
