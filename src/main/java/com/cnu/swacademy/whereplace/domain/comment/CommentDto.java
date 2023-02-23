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
        private Long commentId;
        private PostDto commentedPost;
        private UserDto commentedUser;
        private String content;
        private LocalDateTime postedDate;
        private int commentLike;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Respond{
        private Long commentId;
        private PostDto commentedPost;
        private UserDto commentedUser;
        private String content;
        private LocalDateTime postedDate;
        private int commentLike;
    }
}
