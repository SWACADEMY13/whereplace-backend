package com.cnu.swacademy.whereplace.domain.region;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionDto {

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
    public static class Respond{
        private int regionId;
        private String regionName;
    }

}
