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

@Data
public class PostDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private int postId; // AUTO_INCREMENT
        private UserDto.Request postedUserDto;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto.Request regionDto;
//        private List<CommentDto> commentDtos; // 글 생성할 때는 댓글을 받을 일이 없어서 없어도 될 것 같아서 일단 주석처리 해놨습니다!
        private List<PostTagDto.Request> tagDtos;
        private List<PostImageDto.Request> imageDtos; // NOT NULL

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

    @Getter
    public static class Response{
        private int postId;
        private UserDto.Response postedUserDto;
        private String content;
        private LocalDateTime postedDate;
        private int postLike;
        private RegionDto.Response regionDto;
        private List<CommentDto.Response> commentDtos;
        private List<PostTagDto.Response> tagDtos;
        private List<PostImageDto.Response> imageDtos;

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
                    this.commentDtos = post.getComments().stream().map(CommentDto.Response::new).collect(Collectors.toList());
                }
                if (!tagDtos.isEmpty()) {
                    this.tagDtos = post.getTags().stream().map(PostTagDto.Response::new).collect(Collectors.toList());
                }
            } catch (Exception e) {

            }

            this.imageDtos = post.getImages().stream().map(PostImageDto.Response::new).collect(Collectors.toList());
        }
    }


//    private int postId;
//    private UserDto postedUserDto;
//    private String content;
//    private LocalDateTime postedDate;
//    private int postLike;
//    private RegionDto regionDto;
//    private List<CommentDto> commentDtos;
//    private List<PostTagDto> tagDtos;
//    private List<PostImageDto> imageDtos;
//
//    public PostDto(String content) {
//        this.content = content;
//        this.postedUserDto = UserDto.builder()
//                .userId("test")
//                .password("1234")
//                .name("홍길동")
//                .phone("01012345678")
//                .email("test@gmail.com")
//                .build();
//        this.postedDate = LocalDateTime.now();
//        this.regionDto = RegionDto.builder()
//                .regionId(1)
//                .regionName("대전")
//                .build();
//    }
//    @Override
//    public String toString() {
//        return "PostDto{" + "content='" + content + '\'' + '}';
//    } // 수정 필요,,,
//
//    public Post toEntity(PostDto dto) {
//        Post post = Post.builder()
//                .postedUser(
//                        User.builder()
//                                .userId(dto.postedUserDto.getUserId())
//                                .password(dto.postedUserDto.getPassword())
//                                .name(dto.postedUserDto.getName())
//                                .phone(dto.postedUserDto.getPhone())
//                                .email(dto.postedUserDto.getEmail())
//                                .build()
//                )
//                .content(dto.getContent())
//                .postedDate(dto.getPostedDate())
//                .region(
//                        Region.builder()
//                                .regionName(dto.regionDto.getRegionName())
//                                .build()
//                )
//                .build();
//
//        post.setTags(List.of(
//                PostTag.builder()
//                        .postTag(post)
//                        .hashTag(
//                                HashTag.builder()
//                                        .tagId(dto.getTagDtos().get(0).getHashTagDto().getTagId())
//                                        .tagName(dto.getTagDtos().get(0).getHashTagDto().getTagName())
//                                        .build()
//                        )
//                        .build()
//        ));
//
//        return post;
//    }
}