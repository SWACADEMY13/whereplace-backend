package com.cnu.swacademy.whereplace.domain.post_tag;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;


public class PostTagDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private int postId;
        private PostDto.Request postDto;
        private HashTagDto.Request hashTagDto;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private int postId;
        private PostDto.Response postDto;
        private HashTagDto.Response hashTagDto;
    }

}
