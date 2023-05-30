package com.school.speedrunapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Comments")
@Data
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

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setOP(User OP) {
        this.OP = OP;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setSpeedrun(Speedrun speedrun) {
        this.speedrun = speedrun;
    }
}
