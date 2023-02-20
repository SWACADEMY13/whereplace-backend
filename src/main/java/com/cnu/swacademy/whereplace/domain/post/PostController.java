package com.cnu.swacademy.whereplace.domain.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;


    // 글쓰기 임시 test용
    @GetMapping("/post/new")
    public String createPost(PostDto dto) {
        System.out.println(dto.toString());

        return postService.save(dto);
    }
}
