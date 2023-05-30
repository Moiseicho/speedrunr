package com.school.speedrunapp.service;

import com.school.speedrunapp.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService
{
    List<Category> findAll();
    Category getById(long id);

    Category save(Category category);
    Category update(Category category, long id);
    void delete(long id);
    Optional<Category> getByName(String name);
}
