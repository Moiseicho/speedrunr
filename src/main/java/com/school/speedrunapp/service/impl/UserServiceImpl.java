package com.school.speedrunapp.service.impl;

import com.school.speedrunapp.entity.Ban;
import com.school.speedrunapp.entity.Comment;
import com.school.speedrunapp.entity.Speedrun;
import com.school.speedrunapp.entity.User;
import com.school.speedrunapp.repository.BanRepository;
import com.school.speedrunapp.repository.CommentRepository;
import com.school.speedrunapp.repository.SpeedrunRepository;
import com.school.speedrunapp.repository.UserRepository;
import com.school.speedrunapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final SpeedrunRepository speedrunRepository;
    private final CommentRepository commentRepository;
    private final BanRepository banRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user, long id) {
        User toUpdate = userRepository.getReferenceById(id);
        toUpdate.setEmail(user.getEmail());
        toUpdate.setName(user.getName());
        toUpdate.setPassword(user.getPassword());
        return userRepository.save(toUpdate);
    }

    @Override
    public void delete(long id) {
        User user = userRepository.getReferenceById(id);
        speedrunRepository.getSpeedrunsByUserOrderByGameAscCategoryAscTimeAsc(user)
                .forEach(this::removeUserFromSpeedrun);
        commentRepository.getCommentsByUserOrderByPostDateDesc(user)
                .forEach(this::removeUserFromComment);
        banRepository.getBansByUser(user)
                .forEach(this::removeUserFromBan);
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getByName(String name) {
        return userRepository.getUserByName(name);
    }

    private void removeUserFromSpeedrun(Speedrun speedrun)
    {
        speedrun.setUser(null);
        speedrunRepository.save(speedrun);
    }

    private void removeUserFromComment(Comment comment)
    {
        comment.setUser(null);
        commentRepository.save(comment);
    }

    private void removeUserFromBan(Ban ban)
    {
        ban.setUser(null);
        banRepository.save(ban);
    }

}
