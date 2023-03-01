package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.post.PostService;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final PostService postService;

    private final UserService userService;

    private final CommentRepository commentRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CommentService(PostService postService, UserService userService, CommentRepository repository, ModelMapper modelMapper) {
        this.postService = postService;
        this.userService = userService;
        this.commentRepository = repository;
        this.modelMapper = modelMapper;
    }


    @Transactional
    public Comment save(CommentDto.Request givenRequestCommentDto){

        // DTO -> Entity
        Comment comment = givenRequestCommentDto.toEntity();

        User mappedUser = userService.find(givenRequestCommentDto.getUserId());
        Post mappedPost = postService.find(givenRequestCommentDto.getPostId());


        PostDto.Response mappedPostDto=postService.toDto(mappedPost); // Entity to DTO
        UserDto.Response mappedUserDto=userService.toDto(mappedUser);  // Entity to DTO

        mappedPostDto.getComments().add(comment.getCommentId()); // One to Many add
        mappedUserDto.getComments().add(comment.getCommentId()); // One to Many add

        postService.save(mappedPostDto); // DTO to Entity, and update & persist

        comment.setCommentedUser(mappedUser);
        comment.setCommentedPost(mappedPost);
        comment.setPostedDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    public Comment update(CommentDto.Request givenRequestCommentDto){
        Comment comment = find(givenRequestCommentDto.getCommentId()); // find by id;
        CommentDto.Response responseCommentDto = toDto(comment); // Entity To DTO

        responseCommentDto.setContent(givenRequestCommentDto.getContent()); // DTO update
        comment = givenRequestCommentDto.toEntity(); // DTO to Entity

        return commentRepository.save(comment); // update & persist,
    }

    public Comment find(int commentId){ // Optional<Comment> to Comment
        Optional<Comment> comment = commentRepository.findById(commentId);
        return comment.orElse(null);
    }

    public List<Comment> findAll(int postId){
        Post post = postService.find(postId);
        return post.getComments();
    }

    @PostMapping("/delete-process")
    public void delete(int commentId){
        Comment comment = this.find(commentId);
        try {
            commentRepository.delete(comment);
        } catch (OptimisticLockingFailureException e) {
            Assert.isTrue(true, " in Comment Service : delete");
        }
    }

    public CommentDto.Response toDto(Comment givenComment){
        return modelMapper.map(givenComment,CommentDto.Response.class);
    }
}