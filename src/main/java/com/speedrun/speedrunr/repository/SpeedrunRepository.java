package com.speedrun.speedrunr.repository;

import com.speedrun.speedrunr.entity.Category;
import com.speedrun.speedrunr.entity.Game;
import com.speedrun.speedrunr.entity.Speedrun;
import com.speedrun.speedrunr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeedrunRepository extends JpaRepository<Speedrun, Long>
{
    List<Speedrun> getSpeedrunsByGameAndCategoryOrderByTime(Game game, Category category);
    List<Speedrun> getSpeedrunsByUserOrderByGameAscCategoryAscTimeAsc(User user);
}
