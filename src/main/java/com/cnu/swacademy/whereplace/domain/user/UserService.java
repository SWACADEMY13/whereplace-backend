package com.cnu.swacademy.whereplace.domain.user;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


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

    public User find(String givenUsername){
        Optional<User> foundUser = userRepository.findByUsername(givenUsername);
        log.warn("id : {}",foundUser.get().getUsername());
        return foundUser.orElse(null);
    }

    public Optional<User> login(String username,String password){
        Optional<User> user = userRepository.findById(username);
        return user.isPresent() && Objects.equals(password, user.get().getPassword()) ? user : Optional.empty();
    }
}