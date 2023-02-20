package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private int commentId;
    private PostDto postDto;
    private UserDto commentedUserDto;
    private String content;
    private LocalDateTime postedDate;
    private int commentLike;
}
