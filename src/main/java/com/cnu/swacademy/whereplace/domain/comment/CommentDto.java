package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import com.cnu.swacademy.whereplace.domain.user.UserRepository;
import lombok.*;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CommentDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private Integer commentId; // AUTO_INCREMENT
        private Integer postId;
        private String userId;
        private String content;
        private LocalDateTime postedDate;
        private Integer commentLike;

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