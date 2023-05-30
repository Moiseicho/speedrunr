package com.school.speedrunapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Speedruns")
@Data
public class Speedrun {
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
