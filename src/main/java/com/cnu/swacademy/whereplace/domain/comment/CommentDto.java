package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;
import org.apache.coyote.Response;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private int commentId; // AUTO_INCREMENT
        private PostDto.Request commentedPost;
        private UserDto.Request commentedUser;
        private String content;
        private LocalDateTime postedDate;
//        private int commentLike; // 댓글 생성할 때는 좋아요수가 무조건 0이니까 받을 일이 없을 것 같아서 주석처리 해놨습니다!

        // Dto -> Entity
        public Comment toEntity() {
            return Comment.builder()
                    .postComment(commentedPost.toEntity())
                    .commentedUser(commentedUser.toEntity())
                    .content(content)
                    .postedDate(LocalDateTime.now())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class Response{
        private int commentId;
        private PostDto.Response commentedPost;
        private UserDto.Response commentedUser;
        private String content;
        private LocalDateTime postedDate;
        private int commentLike;

        // Entity -> Dto
        public Response(Comment comment) {
            this.commentId = comment.getCommentId();
            this.commentedPost = new PostDto.Response(comment.getPostComment());
            this.commentedUser = new UserDto.Response(comment.getCommentedUser());
            this.content = comment.getContent();
            this.postedDate = comment.getPostedDate();
            this.commentLike = comment.getCommentLike();
        }
    }
}