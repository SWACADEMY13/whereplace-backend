package com.cnu.swacademy.whereplace.domain.region;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;


public class RegionDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private int regionId;
        private String regionName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private int regionId;
        private String regionName;
    }

}
