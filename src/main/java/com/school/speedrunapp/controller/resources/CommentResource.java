package com.school.speedrunapp.controller.resources;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class CommentResource {
    @Id
    @GeneratedValue
    private Long id;
    private Long speedrunId;
    private Long userId;
    private String comment;
    private Date postDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }
}
