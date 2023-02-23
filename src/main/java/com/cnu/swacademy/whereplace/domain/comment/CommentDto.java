package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;


public class CommentDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private int commentId;
        private PostDto.Request commentedPost;
        private UserDto.Request commentedUser;
        private String content;
        private LocalDateTime postedDate;
        private int commentLike;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private int commentId;
        private PostDto.Response commentedPost;
        private UserDto.Response commentedUser;
        private String content;
        private LocalDateTime postedDate;
        private int commentLike;
    }
}
