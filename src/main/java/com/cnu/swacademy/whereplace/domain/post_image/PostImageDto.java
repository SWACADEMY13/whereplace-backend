package com.cnu.swacademy.whereplace.domain.post_image;

import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostImageDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        private int postId;
        private PostDto postDto;
        private ImageDto image;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Respond{
        private int postId;
        private PostDto postDto;
        private ImageDto image;
    }
}
