package com.cnu.swacademy.whereplace.domain.hashtag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

public class HashTagDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private String tagName;

        public HashTag toEntity(){
            return HashTag.builder()
                    .tagName(tagName)
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Integer tagId;
        private String tagName;
    }
}