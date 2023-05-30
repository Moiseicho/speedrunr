package com.school.speedrunapp.mapper;

import com.school.speedrunapp.controller.resources.SpeedrunResource;
import com.school.speedrunapp.entity.Speedrun;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SpeedrunMapper
{

    SpeedrunMapper SPEEDRUN_MAPPER = Mappers.getMapper(SpeedrunMapper.class);

    @Mapping(target = "user.id", source = "speedrunResource.userId")
    @Mapping(target = "category.id", source = "speedrunResource.categoryId")
    @Mapping(target = "game.id", source = "speedrunResource.gameId")
    Speedrun fromSpeedrunResource(SpeedrunResource speedrunResource);

    @Mapping(target = "userId", source = "speedrun.user.id")
    @Mapping(target = "categoryId", source = "speedrun.category.id")
    @Mapping(target = "gameId", source = "speedrun.game.id")
    SpeedrunResource toSpeedrunResource(Speedrun speedrun);

    List<Speedrun> fromSpeedrunResources(List<SpeedrunResource> speedrunResources);
    List<SpeedrunResource> toSpeedrunResources(List<Speedrun> speedruns);

}
