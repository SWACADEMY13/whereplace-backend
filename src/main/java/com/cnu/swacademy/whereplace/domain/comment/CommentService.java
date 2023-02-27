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
        Comment comment = toEntity(givenRequestCommentDto);

        User mappedUser = userService.find(givenRequestCommentDto.getUserId());
        Post mappedPost = postService.find(givenRequestCommentDto.getPostId());

        // 여기 mappedUser랑 mappedPost 를 다시 DTO로 바꿔서 전달하는 게 좋을지, 그냥 mappedUser, mappedPost로 바로 전달해도 되는지 한 번 박사님께 여쭤보거나 찾아봐야할 것 같아요!
        // 일단 그냥 더 간단하게 바로 전달하는 걸로 해놨습니다.
        /*
        PostDto.Response mappedPostDto = postService.toDto(mappedPost); // Entity to DTO
        UserDto.Response mappedUserDto = userService.toDto(mappedUser);  // Entity to DTO

        mappedPostDto.getCommentDtos().add(comment); // One to Many add
        mappedUserDto.getComments().add(comment); // One to Many add

        postService.save(mappedPostDto); // DTO to Entity, and update & persist
        */
//        postService.save(mappedPost);

        // save 테스트 좀 혀봐, mapper로 바로 User랑 Post 들어가는지,
//        comment.setCommentedUser(mappedUser);
//        comment.setCommentedPost(mappedPost);
        mappedUser.getComments().add(comment);
        mappedPost.getComments().add(comment);

        comment.setPostedDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    public Comment update(CommentDto.Request givenRequestCommentDto){
        Comment comment = find(givenRequestCommentDto.getCommentId()); // find by id;

//        CommentDto.Response responseCommentDto=toDto(comment); // Entity To DTO
//
//        responseCommentDto.setContent(givenRequestCommentDto.getContent()); // DTO update
//        comment=this.toEntity(responseCommentDto); // DTO to Entity

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

    @PostMapping("/delete-process") //////////////////////////////////////////// 질문
    public void delete(int commentId){
        Comment comment = this.find(commentId);
        try {
            commentRepository.delete(comment);
        } catch (OptimisticLockingFailureException e) {
            Assert.isTrue(true, " in Comment Service : delete");
        }
    }


//    public Comment toEntity(CommentDto.Response givenRequestUserDto) {
//        return modelMapper.map(givenRequestUserDto, Comment.class);
//    }

    public Comment toEntity(CommentDto.Request givenRequestUserDto) {
        return modelMapper.map(givenRequestUserDto, Comment.class);
    }

    public CommentDto.Response toDto(Comment givenComment){
        return modelMapper.map(givenComment,CommentDto.Response.class);
    }
}