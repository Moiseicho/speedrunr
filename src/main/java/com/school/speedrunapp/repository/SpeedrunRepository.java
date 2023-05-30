package com.school.speedrunapp.repository;

import com.school.speedrunapp.entity.Category;
import com.school.speedrunapp.entity.Game;
import com.school.speedrunapp.entity.Speedrun;
import com.school.speedrunapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeedrunRepository extends JpaRepository<Speedrun, Long> {
    List<Speedrun> getSpeedrunsByGameAndCategoryOrderByTime(Game game, Category category);

    List<Speedrun> getSpeedrunsByUserOrderByGameAscCategoryAscTimeAsc(User user);

    List<Speedrun> getSpeedrunsByGameOrderByCategoryAscTimeAsc(Game game);

    List<Speedrun> getSpeedrunsByCategoryOrderByGameAscTimeAsc(Category category);
}
