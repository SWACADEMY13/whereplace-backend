package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private int commentId;
        private String content;
        private LocalDateTime postedDate;
        private Integer postCommentId;
        private String commentedUserId;

//        public Comment toEntity() { // 만약 DTO 를 위처럼 바꾼다면 User와 Post의 service 가 필수가 됩니다.
//                return Comment.builder()
//                    .postComment(commentedPostId)
//                    .commentedUser(commentedUserId)
//                    .content(content)
//                    .postedDate(LocalDateTime.now())
//                    .build();
//        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private int commentId;
        private String content;
        private LocalDateTime postedDate;
        private Post postComment;
        private User commentedUser;
        private int commentLike;

        // Entity -> Dto
        public Response(Comment comment) {
            this.commentId = comment.getCommentId();
            this.postComment = comment.getPostComment();
            this.commentedUser = comment.getCommentedUser();
            this.content = comment.getContent();
            this.postedDate = comment.getPostedDate();
            this.commentLike = comment.getCommentLike();
        }
    }
}
