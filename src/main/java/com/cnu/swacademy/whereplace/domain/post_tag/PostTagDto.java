package com.cnu.swacademy.whereplace.domain.post_tag;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class PostTagDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private int postId;
        private PostDto.Request postDto;
        private HashTagDto.Request hashTagDto;

        // Dto -> Entity
        public PostTag toEntity() {
            return PostTag.builder()
                    .postId(postId)
                    .postTag(postDto.toEntity())
                    .hashTag(hashTagDto.toEntity())
                    .build();
        }
    }

    @Getter
    public static class Response{
        private int postId;
        private PostDto.Response postDto;
        private HashTagDto.Response hashTagDto;

        // Entity -> Dto
        public Response(PostTag postTag) {
            this.postId = postTag.getPostId();
            this.postDto = new PostDto.Response(postTag.getPostTag());
            this.hashTagDto = new HashTagDto.Response(postTag.getHashTag());
        }
    }

}