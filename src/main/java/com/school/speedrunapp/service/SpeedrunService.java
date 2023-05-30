package com.school.speedrunapp.service;

import com.school.speedrunapp.controller.resources.SpeedrunResource;
import com.school.speedrunapp.entity.Speedrun;
import com.school.speedrunapp.repository.SpeedrunRepository;

import java.util.List;

public interface SpeedrunService
{
    List<SpeedrunResource> findAll();
    SpeedrunResource getById(long id);

    SpeedrunResource save(SpeedrunResource speedrunResource);
    SpeedrunResource update(SpeedrunResource speedrunResource, long id);
    void delete(long id);

    List<SpeedrunResource> getByGameId(long id);
    List<SpeedrunResource> getByUserId(long id);
    List<SpeedrunResource> getByGameIdAndCategoryId(long gid, long cid);
}
