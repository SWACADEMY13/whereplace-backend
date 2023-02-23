package com.cnu.swacademy.whereplace.domain.user;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class UserService {

//    @Autowired
//    private ModelMapper modelMapper;
    @Autowired
    private UserRepository repository;

    public User getUserDto(UserDto.Request givenRequestUserDto) {
//        return modelMapper.map(givenRequestUserDto, User.class);
        return givenRequestUserDto.toEntity();
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