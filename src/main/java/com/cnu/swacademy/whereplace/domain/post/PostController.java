package com.cnu.swacademy.whereplace.domain.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post/new")
    public String createPost(PostDto dto) {
        System.out.println(dto.toString());

        // 1. dto -> entity
        Post post = dto.toEntity();
        System.out.println(post.toString());

        // 2. entity DB에 저장
        Post saved = postRepository.save(post);
        System.out.println(saved.toString());

        return "";
    }
}
