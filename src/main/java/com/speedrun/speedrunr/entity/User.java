package com.speedrun.speedrunr.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User
{
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