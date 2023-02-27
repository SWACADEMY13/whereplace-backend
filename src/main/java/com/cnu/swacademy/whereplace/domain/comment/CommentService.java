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
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Comment save(CommentDto.Request givenRequestCommentDto){
        Comment comment=toEntity(givenRequestCommentDto);

        User mappedUser=userService.find(givenRequestCommentDto.getCommentedUserId());
        Post mappedPost=postService.find(givenRequestCommentDto.getPostCommentId());

        PostDto.Response mappedPostDto=postService.toDto(mappedPost); // Entity to DTO
        UserDto.Response mappedUserDto=userService.toDto(mappedUser);  // Entity to DTO

        mappedPostDto.getCommentDtos().add(comment); // One to Many add
        mappedUserDto.getComments().add(comment); // One to Many add

        postService.save(mappedPostDto); // DTO to Entity, and update & persist

        comment.setCommentedUser(mappedUser);
        comment.setPostComment(mappedPost);
        comment.setPostedDate(LocalDateTime.now());

        return repository.save(comment);
    }

    public Comment update(CommentDto.Request givenRequestCommentDto){
        Comment comment=find(givenRequestCommentDto.getCommentId()); // find by id;
        CommentDto.Response responseCommentDto=toDto(comment); // Entity To DTO

        responseCommentDto.setContent(givenRequestCommentDto.getContent()); // DTO update
        comment=this.toEntity(responseCommentDto); // DTO to Entity

        return repository.save(comment); // update & persist,
    }

    public Comment find(int commentId){ // Optional<Comment> to Comment
        Optional<Comment> comment= repository.findById(commentId);
        return comment.orElse(null);
    }

    public List<Comment> findAll(int postId){
        Post post=postService.find(postId);
        return post.getComments();
    }

    @PostMapping("/delete-process")
    public void delete(int commentId){
        Comment comment=this.find(commentId);
        try{
            repository.delete(comment);
        }catch(OptimisticLockingFailureException e) {
            Assert.isTrue(true, " in Comment Service : delete");
        }
    }


    public Comment toEntity(CommentDto.Response givenRequestUserDto) {
        return modelMapper.map(givenRequestUserDto, Comment.class);
    }

    public Comment toEntity(CommentDto.Request givenRequestUserDto) {
        return modelMapper.map(givenRequestUserDto, Comment.class);
    }

    public CommentDto.Response toDto(Comment givenComment){
        return modelMapper.map(givenComment,CommentDto.Response.class);
    }
}
