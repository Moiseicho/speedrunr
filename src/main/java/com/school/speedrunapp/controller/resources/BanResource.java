package com.school.speedrunapp.controller.resources;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class BanResource {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String banMessage;
    private int banTime;
    private Date banDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public int getBanTime() {
        return banTime;
    }

    public Date getBanDate() {
        return banDate;
    }

    public String getBanMessage() {
        return banMessage;
    }
}
