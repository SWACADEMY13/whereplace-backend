package com.cnu.swacademy.whereplace.domain.post_tag;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostTagDto {
    private int postId;
    private PostDto postDto;
    private HashTagDto hashTagDto;
}
