package com.school.speedrunapp.service;

import com.school.speedrunapp.controller.resources.CommentResource;

import java.util.List;

public interface CommentService
{
    List<CommentResource> findAll();
    CommentResource getById(long id);

    CommentResource save(CommentResource commentResource);
    CommentResource update(CommentResource commentResource, long id);
    void delete(long id);

    List<CommentResource> getByUserId(long id);
    List<CommentResource> getBySpeedrunId(long id);
}
