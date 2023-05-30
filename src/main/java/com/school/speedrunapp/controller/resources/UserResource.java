package com.school.speedrunapp.controller.resources;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserResource {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
