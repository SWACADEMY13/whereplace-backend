package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTag;
import com.cnu.swacademy.whereplace.domain.post_image.PostImageDto;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTag;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTagDto;
import com.cnu.swacademy.whereplace.domain.region.Region;
import com.cnu.swacademy.whereplace.domain.region.RegionDto;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


public class PostDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private int postId;
        private UserDto postedUserDto;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto.Request regionDto;
        private List<CommentDto.Request> commentDtos;
        private List<PostTagDto.Request> tagDtos;
        private List<PostImageDto.Request> imageDtos;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private int postId;
        private UserDto postedUserDto;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto.Response regionDto;
        private List<CommentDto.Response> commentDtos;
        private List<PostTagDto.Response> tagDtos;
        private List<PostImageDto.Response> imageDtos;
    }
}
