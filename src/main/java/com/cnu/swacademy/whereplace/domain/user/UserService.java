package com.cnu.swacademy.whereplace.domain.user;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository repository;

    @Autowired
    public UserService(ModelMapper modelMapper, UserRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public User toEntity(UserDto.Request givenRequestUserDto) {
        return modelMapper.map(givenRequestUserDto, User.class);
    }

    public User find(String givenUserId){
        Optional<User> foundUser=repository.findById(givenUserId);
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
