package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import lombok.*;

import java.util.List;


public class UserDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private String userId;
        private String password;
        private String name;
        private String phone;
        private String email;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private String userId;
        private String password;
        private String name;
        private String phone;
        private String email;
    }
}
