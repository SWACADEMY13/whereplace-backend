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

// 글쓰기 임시 test용
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private int postId;
    private UserDto postedUserDto;
    private String content;
    private LocalDateTime postedDate;
    private int postLike;
    private RegionDto regionDto;
    private List<CommentDto> commentDtos;
    private List<PostTagDto> tagDtos;
    private List<PostImageDto> imageDtos;

    public PostDto(String content) {
        this.content = content;
        this.postedUserDto = UserDto.builder()
                .userId("test")
                .password("1234")
                .name("홍길동")
                .phone("01012345678")
                .email("test@gmail.com")
                .build();
        this.postedDate = LocalDateTime.now();
        this.regionDto = RegionDto.builder()
                .regionId(1)
                .regionName("대전")
                .build();
    }
    @Override
    public String toString() {
        return "PostDto{" + "content='" + content + '\'' + '}';
    } // 수정 필요,,,

    public Post toEntity(PostDto dto) {
        Post post = Post.builder()
            .postedUser(
                    User.builder()
                            .userId(dto.postedUserDto.getUserId())
                            .password(dto.postedUserDto.getPassword())
                            .name(dto.postedUserDto.getName())
                            .phone(dto.postedUserDto.getPhone())
                            .email(dto.postedUserDto.getEmail())
                            .build()
            )
            .content(dto.getContent())
            .postedDate(dto.getPostedDate())
            .region(
                    Region.builder()
                            .regionName(dto.regionDto.getRegionName())
                            .build()
            )
            .build();

        post.setTags(List.of(
                PostTag.builder()
                        .postTag(post)
                        .hashTag(
                                HashTag.builder()
                                        .tagId(dto.getTagDtos().get(0).getHashTagDto().getTagId())
                                        .tagName(dto.getTagDtos().get(0).getHashTagDto().getTagName())
                                        .build()
                        )
                        .build()
        ));

        return post;
    }
}
