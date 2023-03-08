package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.region.RegionDto;
import com.cnu.swacademy.whereplace.domain.region.RegionService;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private int postId;
        private String userId;
        private String content;
        private LocalDateTime postedDate;
        private List<HashTagDto.Request> hashTags;
        private int postLike;
        private int regionId;

        public Post toEntity() {
            return Post.builder()
                    .content(content)
                    .postedDate(postedDate)
                    .postLike(postLike)
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private int postId;
        private String userId;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto.Response region;
        private List<Integer> comments;
        private List<Integer> tags;
        private List<Integer> images;
    }
}