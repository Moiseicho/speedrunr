package com.school.speedrunapp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Comments")
public class Comment {
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
