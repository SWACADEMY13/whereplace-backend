package com.cnu.swacademy.whereplace.domain.hashtag;

import lombok.*;


public class HashTagDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private Integer tagId;
        private String tagName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private Integer tagId;
        private String tagName;
    }
}
