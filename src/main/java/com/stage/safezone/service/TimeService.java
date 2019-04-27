package com.stage.safezone.service;

import com.stage.safezone.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class TimeService {

    private final EntityManager entityManager;


    @Autowired
    public TimeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Time find(final Long id) {
        return this.entityManager.find(Time.class, id);
    }


}
