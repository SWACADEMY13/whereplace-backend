package com.cnu.swacademy.whereplace.domain.hashtag;

import lombok.*;


@Data
public class HashTagDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private int tagId; // AUTO_INCREMENT
        private String tagName;

        // Dto -> Entity
        public HashTag toEntity() {
            return HashTag.builder()
                    .tagName(tagName).build();
        }
    }

    @Getter
    public static class Response {
        private Integer tagId;
        private String tagName;

        // Entity -> Dto
        public Response(HashTag hashTag) {
            this.tagId = hashTag.getTagId();
            this.tagName = hashTag.getTagName();
        }
    }
}