package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.CommentService;
import com.cnu.swacademy.whereplace.domain.post.PostService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
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

    @Transactional
    public User create(UserDto.Request givenUserDto) {
        User user = givenUserDto.toEntity();
        return userRepository.save(user);
    }

    public User findByUserName(String givenUserName){
        Optional<User> foundUser = userRepository.findByNickname(givenUserName);
//        log.warn("id : {}",foundUser.get().getNickname());
        return foundUser.orElse(null);
    }

    public Optional<User> login(String username,String password){
        Optional<User> user = userRepository.findById(username);
        return user.isPresent() && Objects.equals(password, user.get().getPassword()) ? user : Optional.empty();
    }

    public UserDto.Response toDto(User user) {

        return UserDto.Response.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}