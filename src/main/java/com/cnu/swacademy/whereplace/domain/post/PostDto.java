package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.post_image.PostImage;
import com.cnu.swacademy.whereplace.domain.post_image.PostImageDto;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTag;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTagDto;
import com.cnu.swacademy.whereplace.domain.region.RegionDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private int postId;
        private UserDto.Request postedUserDto;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto.Request regionDto;
        private List<CommentDto.Request> commentDtos;
        private List<PostTagDto.Request> tagDtos;
        private List<PostImageDto.Request> imageDtos;

        // Dto -> Entity
        public Post toEntity() {
            Post post = Post.builder()
                    .postedUser(postedUserDto.toEntity())
                    .content(content)
                    .postedDate(LocalDateTime.now())
                    .region(regionDto.toEntity())
                    .build();

            try {
                post.setTags(tagDtos.stream().map(PostTagDto.Request::toEntity).collect(Collectors.toList()));
                post.setImages(imageDtos.stream().map(PostImageDto.Request::toEntity).collect(Collectors.toList()));
            } catch(Exception e) {

            }

            return post;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private int postId;
        private UserDto.Response postedUserDto;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto.Response regionDto;
        private List<Comment> commentDtos;
        private List<PostTag> tagDtos;
        private List<PostImage> imageDtos;

        // Entity -> Dto
        public Response(Post post) {
            this.postId = post.getPostId();
            this.postedUserDto = new UserDto.Response(post.getPostedUser());
            this.content = post.getContent();
            this.postedDate = post.getPostedDate();
            this.postLike = post.getPostLike();
            this.regionDto = new RegionDto.Response(post.getRegion());
            try {
                if (!commentDtos.isEmpty()) {
                    this.commentDtos = post.getComments().stream().map(Comment::new).collect(Collectors.toList());
                }
                if (!tagDtos.isEmpty()) {
                    this.tagDtos = post.getTags().stream().map(PostTag::new).collect(Collectors.toList());
                }
            } catch (Exception e) {

            }

            this.imageDtos = post.getImages().stream().map(PostImageDto.Response::new).collect(Collectors.toList());
        }
    }
}
