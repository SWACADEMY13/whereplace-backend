package com.cnu.swacademy.whereplace.domain.image;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private Integer imageId;
        private String image;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Respond{
        private Integer imageId;
        private String image;
    }
}
