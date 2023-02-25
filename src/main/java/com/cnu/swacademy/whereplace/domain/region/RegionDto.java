package com.cnu.swacademy.whereplace.domain.region;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;

@Data
public class RegionDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private int regionId; // AUTO_INCREMENT
        private String regionName;

        // Dto -> Entity
        public Region toEntity() {
            return Region.builder()
                    .regionName(regionName)
                    .build();
        }
    }

    @Getter
    public static class Response{
        private int regionId;
        private String regionName;

        // Entity -> Dto
        public Response(Region region) {
            this.regionId = region.getRegionId();
            this.regionName = region.getRegionName();
        }
    }

}
