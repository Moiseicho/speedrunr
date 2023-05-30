package com.school.speedrunapp.service;

import com.school.speedrunapp.controller.resources.BanResource;

import java.util.List;

public interface BanService
{
    List<BanResource> findAll();
    BanResource getById(long id);

    BanResource save(BanResource banResource);
    BanResource update(BanResource banResource, long id);
    void delete(long id);
    List<BanResource> getAllByName(String name);
    List<BanResource> getPermaBans();

}
