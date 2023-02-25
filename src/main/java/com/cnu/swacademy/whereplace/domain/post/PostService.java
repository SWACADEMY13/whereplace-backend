package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public Post find(int givenPostId){
        Optional<Post> foundPost=repository.findById(givenPostId);
        return foundPost.orElse(null);
    }
}
