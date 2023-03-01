package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private String userId;
        private String password;
        private String name;
        private String phone;
        private String email;

        public User toEntity() {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this, User.class);
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private String userId;
        private String password;
        private String name;
        private String phone;
        private String email;
        private List<Integer> comments;
        private List<Integer> posts;
    }
}