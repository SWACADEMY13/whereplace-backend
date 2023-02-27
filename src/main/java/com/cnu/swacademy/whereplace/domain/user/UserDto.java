package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.post.Post;
import lombok.*;

import java.util.ArrayList;
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
        private List<Comment> comments = new ArrayList<>();
        private List<Post> posts = new ArrayList<>();


        // Entity -> Dto
        public Response(User user) {
            this.userId = user.getUserId();
            this.password = user.getPassword();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.email = user.getEmail();
            this.comments =user.getComments();
            this.posts=user.getPosts();
        }
    }
}
