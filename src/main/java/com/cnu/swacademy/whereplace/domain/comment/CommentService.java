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

    public CommentService(PostService postService, UserService userService, CommentRepository repository) {
        this.postService = postService;
        this.userService = userService;
        this.commentRepository = repository;
    }


    @Transactional
    public int create(CommentDto.Request givenRequestCommentDto){
        // DTO -> Entity
        Comment comment = givenRequestCommentDto.toEntity();

        Post foundPost = postService.find(givenRequestCommentDto.getPostId());
        User foundUser = userService.find(givenRequestCommentDto.getUserId());

        comment.setMappingInfo(foundPost,foundUser);
        comment.setPostedDate(LocalDateTime.now());

        return commentRepository.save(comment).getCommentedPost().getPostId();
    } // Comment 자체는 페이지가 없으므로 Post 를 redirect 하기 위한 ID 리턴

    public int update(CommentDto.Request givenRequestCommentDto){
        Comment comment = find(givenRequestCommentDto.getCommentId()); // find by id;
        comment.setContent(givenRequestCommentDto.getContent());
        return commentRepository.save(comment).getCommentId(); // update & persist,
    }

    public Comment find(int commentId){ // Optional<Comment> to Comment
        Optional<Comment> comment = commentRepository.findById(commentId);
        return comment.orElse(null);
    }

    public List<Comment> findAll(int postId){ /* 수정 필요 */
        Post post = postService.find(postId);
//        return post.getComments();
        return null;
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
}