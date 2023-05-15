package com.speedrun.speedrunr.repository;

import com.speedrun.speedrunr.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>
{
    Game getGameByName(String name);
}
