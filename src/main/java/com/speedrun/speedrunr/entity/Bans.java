package com.speedrun.speedrunr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Bans {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;
    private String banMessage;
    private int banTime;
    private Date banDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
