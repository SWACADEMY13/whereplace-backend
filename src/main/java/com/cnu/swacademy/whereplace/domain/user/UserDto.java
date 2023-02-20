package com.cnu.swacademy.whereplace.domain.user;

import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userId;
    private String password;
    private String name;
    private String phone;
    private String email;
}
