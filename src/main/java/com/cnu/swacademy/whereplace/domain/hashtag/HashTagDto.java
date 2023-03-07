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
            ModelMapper modelMapper=new ModelMapper();
            return modelMapper.map(this,HashTag.class);
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private int tagId;
        private String tagName;
    }
}