package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Post find(int givenPostId){
        Optional<Post> foundPost=repository.findById(givenPostId);
        return foundPost.orElse(null);
    }


    public Post save(Post post){
        return repository.save(post);
    }

    public Post save(PostDto.Response givenResponsePostDto){
        Post post=toEntity(givenResponsePostDto);
        return save(post);
    }

    public PostDto.Response toDto(Post givenPost){
        return modelMapper.map(givenPost,PostDto.Response.class);
    }

    public Post toEntity(PostDto.Response givenResponsePostDto){
        return modelMapper.map(givenResponsePostDto,Post.class);
    }

}
