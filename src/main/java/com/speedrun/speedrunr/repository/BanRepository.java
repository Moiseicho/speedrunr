package com.speedrun.speedrunr.repository;

import com.speedrun.speedrunr.entity.Ban;
import com.speedrun.speedrunr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BanRepository extends JpaRepository<Ban, Long>
{
    List<Ban> getBansByUser(User user);

    @Query("SELECT b FROM Ban b WHERE b.banTime = 0")
    List<Ban> getPermaBans();
}
