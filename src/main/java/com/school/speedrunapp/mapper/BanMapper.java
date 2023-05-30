package com.school.speedrunapp.mapper;

import com.school.speedrunapp.controller.resources.BanResource;
import com.school.speedrunapp.entity.Ban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BanMapper
{
    BanMapper MAPPER = Mappers.getMapper(BanMapper.class);

    @Mapping(target = "user.id", source = "banResource.userid")
    Ban fromBanResource(BanResource banResource);

    @Mapping(target = "userId", source = "ban.user.id")
    Ban toBanResource(Ban ban);

    List<BanResource> toBanResources(List<Ban> bans);
    List<Ban> fromBanResources(List<BanResource> banResources);

}
