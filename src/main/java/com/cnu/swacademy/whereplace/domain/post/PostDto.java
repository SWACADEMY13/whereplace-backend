package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.region.RegionDto;
import com.cnu.swacademy.whereplace.domain.region.RegionService;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PostDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private Integer postId;
        private String userId;
        private Optional<String> content = Optional.empty(); // nullable
        private List<HashTagDto.Request> hashTags; // nullable
        private Integer regionId;
        private List<ImageDto.Request> images;

        public Post toEntity() {
            if (content.isPresent()) {
                return Post.builder()
                        .content(content.get())
                        .build();
            }
            else {
                return Post.builder().build();
            }
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private Integer postId;
        private User postedUser;
        private String content;
        private LocalDateTime postedDate;
        private Integer postLike;
        private RegionDto.Response region;
        private List<CommentDto.Response> comments;
        private List<HashTagDto.Response> tags;
        private List<ImageDto.Response> images;
    }
}