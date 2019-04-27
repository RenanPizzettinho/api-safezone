package com.stage.safezone.api;

import com.stage.safezone.model.Time;
import com.stage.safezone.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("times")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Time> find(@PathVariable("id") final Long id) {
        final var time = this.timeService.find(id);
        return ResponseEntity.ok(time);
    }

//    @GetMapping("/search")
//    public ResponseEntity<Time> search(@PathVariable("id") final Long id){
//        final var time = this.timeService.search();
//        return ResponseEntity.ok(time);
//    }


}
