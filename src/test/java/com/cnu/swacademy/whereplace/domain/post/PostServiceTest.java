package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTagDto;
import com.cnu.swacademy.whereplace.domain.region.RegionDto;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Test
    void save_test() {
        // Given
        PostDto postDto = PostDto.builder()
                .postedUserDto(
                        UserDto.builder()
                                .userId("test")
                                .password("1234")
                                .name("홍길동")
                                .phone("01012345678")
                                .email("test@gmail.com")
                                .build())
                .content("test용 content")
                .postedDate(LocalDateTime.now())
                .regionDto(
                        RegionDto.builder()
                                .regionId(1)
                                .regionName("대전")
                                .build()
                )
                .build();

        postDto.setTagDtos(List.of(
                PostTagDto.builder()
                        .postId(postDto.getPostId())
                        .hashTagDto(
                                HashTagDto.builder()
                                        .tagName("#바다")
                                        .build()
                        ).build()
        ));

        // When
        String saved = postService.save(postDto);

        // Then
//        log.info("{}", saved);
        System.out.println(saved);
    }
}