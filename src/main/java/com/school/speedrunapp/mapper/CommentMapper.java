package com.school.speedrunapp.mapper;

import com.school.speedrunapp.controller.resources.CommentResource;
import com.school.speedrunapp.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper
{
    CommentMapper MAPPER = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "speedrun.id", source = "commentResource.speedrunId")
    @Mapping(target = "OP.id", source = "commentResource.OPId")
    Comment fromCommentResource(CommentResource commentResource);

    @Mapping(target = "speedrunId", source = "comment.speedrun.id")
    @Mapping(target = "OPId", source = "comment.OP.id")
    CommentResource toCommentResource(Comment comment);

    List<Comment> fromCommentResource(List<CommentResource> commentResources);
    List<CommentResource> toCommentResource(List<Comment> comments);
}
