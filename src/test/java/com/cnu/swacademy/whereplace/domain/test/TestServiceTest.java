package com.cnu.swacademy.whereplace.domain.test;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestServiceTest {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void run(){
        ModelMapper modelMapper=new ModelMapper();
        TestEntity input4=modelMapper.map(new TestDto.OneMemberDto(5), TestEntity.class);

        testRepository.save(input4);
    }
}