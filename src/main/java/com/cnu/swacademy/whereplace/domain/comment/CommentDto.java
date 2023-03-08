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
        private int commentId; // AUTO_INCREMENT
        private int postId;
        private String userId;
        private String content;
        private LocalDateTime postedDate;
        private int commentLike;

        public Comment toEntity() {
            return Comment.builder()
                    .content(content)
                    .postedDate(postedDate)
                    .commentLike(commentLike)
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private int commentId;
        private Post post;
        private User user;
        private String content;
        private LocalDateTime postedDate;
        private int commentLike;
    }
}