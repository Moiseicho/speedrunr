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
    CommentMapper COMMENT_MAPPER = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "speedrun.id", source = "commentResource.speedrunId")
    @Mapping(target = "user.id", source = "commentResource.userId")
    Comment fromCommentResource(CommentResource commentResource);

    @Mapping(target = "speedrunId", source = "comment.speedrun.id")
    @Mapping(target = "userId", source = "comment.user.id")
    CommentResource toCommentResource(Comment comment);

    List<Comment> fromCommentResources(List<CommentResource> commentResources);
    List<CommentResource> toCommentResources(List<Comment> comments);
}
