package com.school.speedrunapp.service.impl;

import com.school.speedrunapp.controller.resources.SpeedrunResource;
import com.school.speedrunapp.entity.Comment;
import com.school.speedrunapp.entity.Speedrun;
import com.school.speedrunapp.repository.CommentRepository;
import com.school.speedrunapp.repository.SpeedrunRepository;
import com.school.speedrunapp.service.CategoryService;
import com.school.speedrunapp.service.GameService;
import com.school.speedrunapp.service.SpeedrunService;
import com.school.speedrunapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.school.speedrunapp.mapper.SpeedrunMapper.SPEEDRUN_MAPPER;

@Service
@RequiredArgsConstructor
public class SpeedrunServiceImpl implements SpeedrunService
{
    private final SpeedrunRepository speedrunRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final GameService gameService;
    private final CommentRepository commentRepository;

    @Override
    public List<SpeedrunResource> findAll() {
        return SPEEDRUN_MAPPER.toSpeedrunResources(speedrunRepository.findAll());
    }

    @Override
    public SpeedrunResource getById(long id) {
        return SPEEDRUN_MAPPER.toSpeedrunResource(speedrunRepository.getReferenceById(id));
    }

    @Override
    public SpeedrunResource save(SpeedrunResource speedrunResource) {
        Speedrun speedrun = SPEEDRUN_MAPPER.fromSpeedrunResource(speedrunResource);
        speedrun.setGame(gameService.getById(speedrunResource.getGameId()));
        speedrun.setCategory(categoryService.getById(speedrunResource.getCategoryId()));
        speedrun.setUser(userService.getById(speedrunResource.getUserId()));
        speedrun.setTime(speedrunResource.getTime());
        return SPEEDRUN_MAPPER.toSpeedrunResource(speedrunRepository.save(speedrun));
    }

    @Override
    public SpeedrunResource update(SpeedrunResource speedrunResource, long id) {
        Speedrun toUpdate = speedrunRepository.getReferenceById(id);
        toUpdate.setUser(userService.getById(speedrunResource.getUserId()));
        toUpdate.setGame(gameService.getById(speedrunResource.getGameId()));
        toUpdate.setCategory(categoryService.getById(speedrunResource.getCategoryId()));
        toUpdate.setTime(speedrunResource.getTime());
        return SPEEDRUN_MAPPER.toSpeedrunResource(speedrunRepository.save(toUpdate));
    }

    @Override
    public void delete(long id) {
        commentRepository.getCommentsBySpeedrunOrderByPostDateDesc(
                speedrunRepository.getReferenceById(id)
        ).forEach(this::removeSpeedrun);
        speedrunRepository.deleteById(id);
    }

    @Override
    public List<SpeedrunResource> getByGameId(long id) {
        return SPEEDRUN_MAPPER.toSpeedrunResources(
                speedrunRepository.getSpeedrunsByGameOrderByCategoryAscTimeAsc(
                        gameService.getById(id)
                )
        );
    }

    @Override
    public List<SpeedrunResource> getByUserId(long id) {
        return SPEEDRUN_MAPPER.toSpeedrunResources(
                speedrunRepository.getSpeedrunsByGameOrderByCategoryAscTimeAsc(
                        gameService.getById(id)
                )
        );
    }

    @Override
    public List<SpeedrunResource> getByGameIdAndCategoryId(long gid, long cid) {
        return SPEEDRUN_MAPPER.toSpeedrunResources(
                speedrunRepository.getSpeedrunsByGameAndCategoryOrderByTime(
                        gameService.getById(gid),
                        categoryService.getById(cid)
                )
        );
    }

    private void removeSpeedrun(Comment comment)
    {
        comment.setSpeedrun(null);
        commentRepository.save(comment);
    }
}
