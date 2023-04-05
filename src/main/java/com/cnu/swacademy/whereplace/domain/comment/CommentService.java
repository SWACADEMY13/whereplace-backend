package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostService;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final PostService postService;
    private final UserService userService;
    private final CommentRepository commentRepository;

    public CommentService(PostService postService, UserService userService, CommentRepository repository) {
        this.postService = postService;
        this.userService = userService;
        this.commentRepository = repository;
    }


    @Transactional
    public Comment create(CommentDto.Request dto){
        // DTO -> Entity
        Comment comment = dto.toEntity();

        Post foundPost = postService.findById(dto.getPostId());
        User foundUser = userService.findByUserName(dto.getNickname());

        comment.setMappingInfo(foundPost,foundUser);
        comment.setPostedDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    @Transactional
    public Comment update(CommentDto.Request dto){
        Comment comment = findById(dto.getCommentId()); // find by id;
        comment.setContent(dto.getContent());
        comment.setCommentLike(dto.getCommentLike());
        return commentRepository.save(comment); // update & persist,
    }

    public Comment findById(int commentId){ // Optional<Comment> to Comment
        Optional<Comment> comment = commentRepository.findById(commentId);
        return comment.orElse(null);
    }

    public List<Comment> findAllByPostId(int postId){
        return commentRepository.findAllByCommentedPost_PostId(postId);
    }

    @Transactional
    public void delete(int commentId){
        Comment comment = findById(commentId);
        try {
            commentRepository.delete(comment);
        } catch (OptimisticLockingFailureException e) {
            Assert.isTrue(true, " in Comment Service : delete");
        }
    }

    @Transactional
    public void deleteAllByPostId(int postId) {
        commentRepository.deleteAllByCommentedPost_PostId(postId);
    }

    public CommentDto.Response toDto(Comment comment) {
        Comment pComment = findById(comment.getCommentId());

        return CommentDto.Response.builder()
                .commentId(pComment.getCommentId())
                .post(pComment.getCommentedPost())
                .user(pComment.getCommentedUser())
                .content(pComment.getContent())
                .postedDate(pComment.getPostedDate())
                .commentLike(pComment.getCommentLike()).build();
    }
}