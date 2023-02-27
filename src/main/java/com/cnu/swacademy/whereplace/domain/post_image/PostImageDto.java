package com.cnu.swacademy.whereplace.domain.post_image;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;

public class PostImageDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private int postId;
        private int imageId;

//        // Dto -> Entity
//        public PostImage toEntity() {
//            return PostImage.builder()
//                    .postId(postId)
//                    .postImage(postDto.toEntity())
//                    .image(image.toEntity())
//                    .build();
//        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private int postId;
        private int imageId;

//        // Entity -> Dto
//        public Response(PostImage postImage) {
//            this.postId = postImage.getPostId();
//            this.postDto = new PostDto.Response(postImage.getPostImage());
//            this.image = new ImageDto.Response(postImage.getImage());
//        }
    }
}