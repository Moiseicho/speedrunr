package com.school.speedrunapp.service.impl;

import com.school.speedrunapp.entity.Category;
import com.school.speedrunapp.entity.Speedrun;
import com.school.speedrunapp.repository.CategoryRepository;
import com.school.speedrunapp.repository.SpeedrunRepository;
import com.school.speedrunapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryRepository categoryRepository;
    private final SpeedrunRepository speedrunRepository;

    @Override
    public List<Category> findAll() { return categoryRepository.findAll(); }

    @Override
    public Category getById(long id) { return categoryRepository.getReferenceById(id); }

    @Override
    public Category save(Category category) { return categoryRepository.save(category); }

    @Override
    public Category update(Category category, long id)
    {
        Category toUpdate = categoryRepository.getReferenceById(id);
        toUpdate.setName(category.getName());

        return categoryRepository.save(toUpdate);
    }

    @Override
    public void delete(long id)
    {
        speedrunRepository.getSpeedrunsByCategoryOrderByGameAscTimeAsc(
                categoryRepository.getReferenceById(id)
        ).forEach(this::removeCategory);
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> getByName(String name)
    {
        return categoryRepository.getCategoryByName(name);
    }

    private void removeCategory(Speedrun speedrun)
    {
        speedrun.setCategory(null);
        speedrunRepository.save(speedrun);
    }


}
