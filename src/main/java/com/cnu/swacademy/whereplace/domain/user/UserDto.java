package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private String nickname;
        private String password;
        private String name;
        private String phone;
        private String email;

        public User toEntity() {
            return User.builder()
                    .nickname(nickname)
                    .password(password)
                    .name(name)
                    .phone(phone)
                    .email(email)
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private Long userId;
        private String nickname;
        private String name;
        private String phone;
        private String email;
    }
}