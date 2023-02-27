package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final CommentService commentService;
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;

    @Autowired
    public PostService(CommentService commentService, ModelMapper modelMapper, PostRepository postRepository) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
    }

    public Post find(int givenPostId){
        Optional<Post> foundPost = postRepository.findById(givenPostId);
        return foundPost.orElse(null);
    }

    @Transactional
    public Post save(PostDto.Request dto) {

        // 1. dto -> entity
        Post post = toEntity(dto);



        return postRepository.save(post);
    }

    public PostDto.Response toDto(Post givenPost){
        return modelMapper.map(givenPost,PostDto.Response.class);
    }

    public Post toEntity(PostDto.Request givenRequestPostDto){
        modelMapper.typeMap(PostDto.Request.class, Post.class).addMappings(mapper -> {
            mapper.map(postDto -> postDto.getCommentDtos().stream().map(commentService::toEntity).collect(Collectors.toList()),
                    Post::setComments);
//            mapper.map(postDto -> postDto.getTagDtos().stream().map(tag))
        });
        return modelMapper.map(givenRequestPostDto,Post.class);
    }
}
