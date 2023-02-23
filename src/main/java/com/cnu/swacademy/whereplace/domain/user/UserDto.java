package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private String userId;
        private String password;
        private String name;
        private String phone;
        private String email;

        // Dto -> Entity
        public User toEntity() {
            return User.builder()
                    .userId(userId)
                    .password(password)
                    .name(name)
                    .phone(phone)
                    .email(email)
                    .build();
        }
    }

    @Getter
    public static class Response{
        private String userId;
        private String password;
        private String name;
        private String phone;
        private String email;

        // Entity -> Dto
        public Response(User user) {
            this.userId = user.getUserId();
            this.password = user.getPassword();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.email = user.getEmail();
        }
    }
}