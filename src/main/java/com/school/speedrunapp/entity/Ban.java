package com.school.speedrunapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Bans")
@Data
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

    public void setUser(User user) { this.user = user; }

    public User getUser() {
        return user;
    }

    public void setBanDate(Date banDate) {
        this.banDate = banDate;
    }

    public void setBanMessage(String banMessage) {
        this.banMessage = banMessage;
    }

    public void setBanTime(int banTime) {
        this.banTime = banTime;
    }
}
