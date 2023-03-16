package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.image.ImageDto;
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
        private Integer postId;
        private String userId;
        private String content;
        private LocalDateTime postedDate;
        private List<HashTagDto.Request> hashTags;
        private Integer postLike;
        private Integer regionId;
        private List<ImageDto.Request> images;

        public Post toEntity() {
            return Post.builder()
                    .content(content)
                    .build();
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private Integer postId;
        private String userId;
        private String content;
        private LocalDateTime postedDate;
        private Integer postLike;
        private RegionDto.Response region;
        private List<Integer> comments;
        private List<Integer> tags;
        private List<Integer> images;
    }
}