package com.speedrun.speedrunr.repository;

import com.speedrun.speedrunr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User getUserByName(String name);
}
