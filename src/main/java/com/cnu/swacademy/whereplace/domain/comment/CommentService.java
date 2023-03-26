package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostService;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserService;
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
    public int create(CommentDto.Request dto){
        // DTO -> Entity
        Comment comment = dto.toEntity();

        Post foundPost = postService.find(dto.getPostId());
        User foundUser = userService.find(dto.getUsername());

        comment.setMappingInfo(foundPost,foundUser);
        comment.setPostedDate(LocalDateTime.now());

        return commentRepository.save(comment).getCommentedPost().getPostId();
    } // Comment 자체는 페이지가 없으므로 Post 를 redirect 하기 위한 ID 리턴

    @Transactional
    public int update(CommentDto.Request dto){
        Comment comment = find(dto.getCommentId()); // find by id;
        comment.setContent(dto.getContent());
        return commentRepository.save(comment).getCommentId(); // update & persist,
    }

    public Comment find(int commentId){ // Optional<Comment> to Comment
        Optional<Comment> comment = commentRepository.findById(commentId);
        return comment.orElse(null);
    }

    public List<Comment> findAll(int postId){
        return commentRepository.findAllByCommentedPost_PostId(postId);
    }

    @Transactional
    public void delete(int commentId){
        Comment comment = this.find(commentId);
        try {
            commentRepository.delete(comment);
            // User 의 comments 에서도 빼야함.
        } catch (OptimisticLockingFailureException e) {
            Assert.isTrue(true, " in Comment Service : delete");
        }
    }

    @Transactional
    public void delete(Post post) {
        commentRepository.deleteAllByCommentedPost_PostId(post.getPostId());
    }

    public static CommentDto.Response toDto(Comment comment) {
        return CommentDto.Response.builder()
                .commentId(comment.getCommentId())
                .post(comment.getCommentedPost())
                .user(comment.getCommentedUser())
                .content(comment.getContent())
                .postedDate(comment.getPostedDate())
                .commentLike(comment.getCommentLike()).build();
    }
}