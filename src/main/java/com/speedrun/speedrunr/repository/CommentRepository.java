package com.speedrun.speedrunr.repository;

import com.speedrun.speedrunr.entity.Comment;
import com.speedrun.speedrunr.entity.Speedrun;
import com.speedrun.speedrunr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>
{
    List<Comment> getCommentsByOPOrderByPostDateDesc(User OP);
    List<Comment> getCommentsBySpeedrunOrderByPostDateDesc(Speedrun speedrun);
}
