package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentService;
import com.cnu.swacademy.whereplace.domain.post_image.PostImage;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTag;
import com.cnu.swacademy.whereplace.domain.region.RegionService;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final CommentService commentService;
    private final UserService userService;
    private final RegionService regionService;
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;

    @Autowired
    public PostService(CommentService commentService, UserService userService, RegionService regionService, ModelMapper modelMapper, PostRepository postRepository) {
        this.commentService = commentService;
        this.userService = userService;
        this.regionService = regionService;
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
    }

    public Post find(int givenPostId){
        Optional<Post> foundPost = postRepository.findById(givenPostId);
        return foundPost.orElse(null);
    }

    @Transactional
    public Post save(PostDto.Request dto) {
        Post post = dto.toEntity(userService, regionService);
        return postRepository.save(post);
    }

    public Post save(PostDto.Response givenResponsePostDto){
        Post post = givenResponsePostDto.toEntity(userService, regionService);
        return postRepository.save(post);
    }

    public PostDto.Response toDto(Post givenPost){
        PostDto.Response postDto = modelMapper.map(givenPost,PostDto.Response.class);
        postDto.setComments(givenPost.getComments().stream().map(Comment::getCommentId).collect(Collectors.toList()));
        postDto.setTags(givenPost.getTags().stream().map(postTag -> postTag.getHashTag().getTagId()).collect(Collectors.toList()));
        postDto.setImages(givenPost.getImages().stream().map(postImage -> postImage.getImage().getImageId()).collect(Collectors.toList()));
        return postDto;
    }
}
