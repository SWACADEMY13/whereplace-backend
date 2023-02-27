package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTag;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.image.ImageDto;
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
import java.util.stream.Collectors;

public class PostDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private int postId; // AUTO_INCREMENT
        private String userId;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private int regionId;
        private List<CommentDto.Request> commentDtos;
        private List<PostTagDto.Request> tagDtos;
        private List<PostImageDto.Request> imageDtos; // NOT NULL
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
        private int regionId;
        private List<CommentDto.Request> commentDtos;
        private List<PostTagDto.Request> tagDtos;
        private List<PostImageDto.Request> imageDtos;
    }
}