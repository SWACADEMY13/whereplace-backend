package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.region.Region;
import com.cnu.swacademy.whereplace.domain.user.User;

import java.time.LocalDateTime;

// 글쓰기 임시 test용
public class PostDto {
    private String content;

    public PostDto(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostDto{" + "content='" + content + '\'' + '}';
    }

    public Post toEntity() {
        return Post.builder().postedUser(User.builder().userId("test").password("test").name("test_user").phone("010-0000-0000").email("test@gmail.com")
                .build()).region(Region.builder().regionName("대전").build()).content(content).postedDate(LocalDateTime.now()).build();
    }
}
