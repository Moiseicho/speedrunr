package com.school.speedrunapp.controller.resources;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SpeedrunResource {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long categoryId;
    private Long gameId;
    private Long time;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
