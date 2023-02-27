package com.cnu.swacademy.whereplace.domain.post_tag;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;

public class PostTagDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private int postId;
        private int tagId;

//        // Dto -> Entity
//        public PostTag toEntity() {
//            return PostTag.builder()
//                    .postId(postId)
//                    .postTag(postDto.toEntity())
//                    .hashTag(hashTagDto.toEntity())
//                    .build();
//        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private int postId;
        private int tagId;

//        // Entity -> Dto
//        public Response(PostTag postTag) {
//            this.postId = postTag.getPostId();
//            this.postDto = new PostDto.Response(postTag.getPostTag());
//            this.hashTagDto = new HashTagDto.Response(postTag.getHashTag());
//        }
    }

}