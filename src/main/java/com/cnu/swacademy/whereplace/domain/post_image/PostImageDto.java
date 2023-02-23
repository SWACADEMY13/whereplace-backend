package com.cnu.swacademy.whereplace.domain.post_image;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class PostImageDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private int postId;
        private PostDto.Request postDto;
        private ImageDto.Request image;

        // Dto -> Entity
        public PostImage toEntity() {
            return PostImage.builder()
                    .postId(postId)
                    .postImage(postDto.toEntity())
                    .image(image.toEntity())
                    .build();
        }
    }

    @Getter
    public static class Response{
        private int postId;
        private PostDto.Response postDto;
        private ImageDto.Response image;

        // Entity -> Dto
        public Response(PostImage postImage) {
            this.postId = postImage.getPostId();
            this.postDto = new PostDto.Response(postImage.getPostImage());
            this.image = new ImageDto.Response(postImage.getImage());
        }
    }
}