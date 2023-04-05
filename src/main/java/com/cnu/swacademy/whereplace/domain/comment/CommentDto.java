package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class CommentDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private Integer commentId; // AUTO_INCREMENT
        private Integer postId;
        private String nickname;
        private String content;
        private LocalDateTime postedDate;
        @Builder.Default
        private Integer commentLike = 0;

        public Comment toEntity() {
            return Comment.builder()
                    .content(content)
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private Integer commentId;
        private Post post;
        private User user;
        private String content;
        private LocalDateTime postedDate;
        private Integer commentLike;
    }
}