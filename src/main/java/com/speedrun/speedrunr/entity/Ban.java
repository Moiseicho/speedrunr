package com.speedrun.speedrunr.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Bans")
public class Ban {
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
