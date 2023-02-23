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
    public static class REQUEST{
        private int postId;
        private UserDto postedUserDto;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto regionDto;
        private List<CommentDto> commentDtos;
        private List<PostTagDto> tagDtos;
        private List<PostImageDto> imageDtos;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RESPOND{
        private int postId;
        private UserDto postedUserDto;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto regionDto;
        private List<CommentDto> commentDtos;
        private List<PostTagDto> tagDtos;
        private List<PostImageDto> imageDtos;
    }
}
