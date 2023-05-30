package com.school.speedrunapp.service;

import com.school.speedrunapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    List<User> findAll();
    User getById(long id);

    User save(User user);
    User update(User user, long id);
    void delete(long id);

    Optional<User> getByName(String name);

}
