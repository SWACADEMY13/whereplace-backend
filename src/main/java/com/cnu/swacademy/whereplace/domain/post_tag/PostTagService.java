package com.cnu.swacademy.whereplace.domain.post_tag;


import com.cnu.swacademy.whereplace.domain.hashtag.HashTag;
import com.cnu.swacademy.whereplace.domain.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostTagService {

    private final PostTagRepository postTagRepository;

    public PostTagService(PostTagRepository postTagRepository) {
        this.postTagRepository = postTagRepository;
    }

    public void create(Post post, HashTag hashTag){
        PostTag postTag = new PostTag(post, hashTag);
        postTagRepository.save(postTag);
    }
}
