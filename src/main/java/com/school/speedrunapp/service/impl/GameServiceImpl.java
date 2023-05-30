package com.school.speedrunapp.service.impl;

import com.school.speedrunapp.entity.Game;
import com.school.speedrunapp.entity.Speedrun;
import com.school.speedrunapp.repository.GameRepository;
import com.school.speedrunapp.repository.SpeedrunRepository;
import com.school.speedrunapp.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService
{
    private final GameRepository gameRepository;
    private final SpeedrunRepository speedrunRepository;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game getById(long id) {
        return gameRepository.getReferenceById(id);
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game update(Game game, long id) {
        Game toUpdate = gameRepository.getReferenceById(id);
        toUpdate.setName(game.getName());
        return gameRepository.save(toUpdate);
    }

    @Override
    public void delete(long id) {
        speedrunRepository.getSpeedrunsByGameOrderByCategoryAscTimeAsc(
                gameRepository.getReferenceById(id)
        ).forEach(this::removeGame);
        gameRepository.deleteById(id);
    }

    @Override
    public Optional<Game> getByName(String name) {
        return gameRepository.getGameByName(name);
    }

    private void removeGame(Speedrun speedrun)
    {
        speedrun.setGame(null);
        speedrunRepository.save(speedrun);
    }

}
