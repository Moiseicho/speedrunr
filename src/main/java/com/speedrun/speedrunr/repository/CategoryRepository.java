package com.speedrun.speedrunr.repository;

import com.speedrun.speedrunr.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Category getCategoryByName(String name);
}
