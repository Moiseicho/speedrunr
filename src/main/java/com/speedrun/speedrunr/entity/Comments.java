package com.speedrun.speedrunr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Comments {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Speedrun speedrun;
    @ManyToOne
    private User OP;
    private String comment;
    private Date postDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
