package com.school.speedrunapp.service.impl;

import com.school.speedrunapp.controller.resources.CommentResource;
import com.school.speedrunapp.entity.Comment;
import com.school.speedrunapp.repository.CommentRepository;
import com.school.speedrunapp.service.CommentService;
import com.school.speedrunapp.service.SpeedrunService;
import com.school.speedrunapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.school.speedrunapp.mapper.CommentMapper.COMMENT_MAPPER;
import static com.school.speedrunapp.mapper.SpeedrunMapper.SPEEDRUN_MAPPER;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService
{
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final SpeedrunService speedrunService;

    @Override
    public List<CommentResource> findAll()
    {
        return COMMENT_MAPPER.toCommentResources(commentRepository.findAll());
    }

    @Override
    public CommentResource getById(long id)
    {
        return COMMENT_MAPPER.toCommentResource(commentRepository.getReferenceById(id));
    }

    @Override
    public CommentResource save(CommentResource commentResource)
    {
        Comment comment = COMMENT_MAPPER.fromCommentResource(commentResource);
        comment.setOP(userService.getById(commentResource.getOPId()));
        comment.setSpeedrun(
                SPEEDRUN_MAPPER.fromSpeedrunResource(
                        speedrunService.getById(commentResource.getSpeedrunId()
                        )
                )
        );
        return COMMENT_MAPPER.toCommentResource(commentRepository.save(comment));
    }

    @Override
    public CommentResource update(CommentResource commentResource, long id) {
        Comment toUpdate = commentRepository.getReferenceById(id);
        toUpdate.setComment(commentResource.getComment());
        toUpdate.setOP(userService.getById(commentResource.getOPId()));
        toUpdate.setSpeedrun(
                SPEEDRUN_MAPPER.fromSpeedrunResource(
                        speedrunService.getById(commentResource.getSpeedrunId())
                )
        );
        toUpdate.setPostDate(commentResource.getPostDate());
        return COMMENT_MAPPER.toCommentResource(commentRepository.save(toUpdate));
    }

    @Override
    public void delete(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentResource> getByOpId(long id) {
        return COMMENT_MAPPER.toCommentResources(
                commentRepository.getCommentsByOPOrderByPostDateDesc(
                        userService.getById(id)
                )
        );
    }

    @Override
    public List<CommentResource> getBySpeedrunId(long id) {
        return COMMENT_MAPPER.toCommentResources(
                commentRepository.getCommentsBySpeedrunOrderByPostDateDesc(
                        SPEEDRUN_MAPPER.fromSpeedrunResource(
                                speedrunService.getById(id)
                        )
                )
        );
    }
}
