package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
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

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User find(String givenUserId){
        Optional<User> foundUser = userRepository.findById(givenUserId);
        log.warn("id : {}",foundUser.get().getUserId());
        return foundUser.orElse(null);
    }

    @Transactional
    public User create(UserDto.Request givenUserDto) {
        User user = givenUserDto.toEntity();
        return userRepository.save(user);
    }

    public Optional<User> login(String userId,String password){
        Optional<User> user = userRepository.findById(userId);
        return user.isPresent() && Objects.equals(password, user.get().getPassword()) ? user : Optional.empty();
    }

    public static UserDto.Response toDto(User givenUser){
        return UserDto.Response.builder()
                .userId(givenUser.getUserId())
                .password(givenUser.getPassword())
                .name(givenUser.getName())
                .phone(givenUser.getPhone())
                .email(givenUser.getEmail())
                .comments(givenUser.getComments().stream().map(CommentService::toDto).collect(Collectors.toList()))
                .posts(givenUser.getPosts().stream().map(PostService::toDto).collect(Collectors.toList()))
                .build();
    }
}