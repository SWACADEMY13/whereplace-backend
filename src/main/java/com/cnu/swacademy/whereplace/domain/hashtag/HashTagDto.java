package com.cnu.swacademy.whereplace.domain.hashtag;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;

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