package com.cnu.swacademy.whereplace.domain.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

//    @Transactional
//    public String save(PostDto dto) {
//
//        // 1. dto -> entity
//        Post post = dto.toEntity(dto);
//
//        // 2. entity DB에 저장
//        Post saved = postRepository.save(post);
//
//        return saved.toString();
//    }
}
