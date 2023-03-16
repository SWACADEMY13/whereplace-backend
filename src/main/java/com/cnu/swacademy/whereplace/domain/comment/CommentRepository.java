package com.cnu.swacademy.whereplace.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByCommentedPost_PostId(int postId);

    void deleteAllByCommentedPost_PostId(int postId);
}
