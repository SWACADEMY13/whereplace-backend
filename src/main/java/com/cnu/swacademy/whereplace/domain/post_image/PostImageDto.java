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
    private int postId;
    private PostDto postDto;
    private ImageDto image;
}
