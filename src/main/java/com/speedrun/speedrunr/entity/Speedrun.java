package com.speedrun.speedrunr.entity;

import jakarta.persistence.*;

@Entity
public class Speedrun
{
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Game game;
    private Long time;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
