package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentService;
import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User find(String givenUserId){
        Optional<User> foundUser=repository.findById(givenUserId);
        log.warn("id : {}",foundUser.get().getUserId());
        return foundUser.orElse(null);
    }

    @Transactional
    public User save(User givenUserDto) {
        return repository.save(givenUserDto);
    }

    public Optional<User> login(String userId,String password){
        Optional<User> user= repository.findById(userId);
        return user.isPresent() && Objects.equals(password, user.get().getPassword()) ? user : Optional.empty();
    }
}