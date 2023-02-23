package com.cnu.swacademy.whereplace.domain.post_image;

import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;

public class PostImageDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private int postId;
        private PostDto.Request postDto;
        private ImageDto.Request image;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private int postId;
        private PostDto.Response postDto;
        private ImageDto.Response image;
    }
}
