package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.post_image.PostImageDto;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTagDto;
import com.cnu.swacademy.whereplace.domain.region.RegionService;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import jakarta.annotation.PostConstruct;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

        public Post toEntity(UserService userService, RegionService regionService) {
            ModelMapper modelMapper = new ModelMapper();
            Post post = modelMapper.map(this, Post.class);
            post.setPostedUser(userService.find(userId));
            post.setRegion(regionService.find(regionId));
            return post;
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
        private int regionId;
        private List<Integer> comments;
        private List<Integer> tags;
        private List<Integer> images;

        public Post toEntity(UserService userService, RegionService regionService) {
            ModelMapper modelMapper = new ModelMapper();
            Post post = modelMapper.map(this, Post.class);
            post.setPostedUser(userService.find(userId));
            post.setRegion(regionService.find(regionId));
            return post;
        }
    }
}