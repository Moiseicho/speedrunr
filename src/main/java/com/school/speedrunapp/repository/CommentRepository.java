package com.school.speedrunapp.repository;

import com.school.speedrunapp.entity.Comment;
import com.school.speedrunapp.entity.Speedrun;
import com.school.speedrunapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentsByUserOrderByPostDateDesc(User user);

    List<Comment> getCommentsBySpeedrunOrderByPostDateDesc(Speedrun speedrun);


}
