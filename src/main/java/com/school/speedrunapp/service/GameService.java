package com.school.speedrunapp.service;

import com.school.speedrunapp.entity.Game;

import java.util.List;
import java.util.Optional;

public interface GameService
{
    List<Game> findAll();
    Game getById(long id);

    Game save(Game game);
    Game update(Game game, long id);
    void delete(long id);

    Optional<Game> getByName(String name);
}
