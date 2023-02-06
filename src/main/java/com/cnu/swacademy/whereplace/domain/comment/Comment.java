package com.cnu.swacademy.whereplace.domain.comment;

import java.time.LocalDateTime;

public class Comment {
    private final int commentId;            // NOT NULL
    private final int postId;               // NOT NULL
    private final String userId;            // NOT NULL
    private String content;                 // NOT NULL
    private final LocalDateTime postedDate; // NOT NULL
    private int like;

    public Comment(int commentId, int postId, String userId, String content, LocalDateTime postedDate, int like) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.postedDate = postedDate;
        this.like = like;
    }

    public void like() {
        this.like++;
    }

    public int getCommentId() {
        return commentId;
    }

    public int getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPostedDate() {
        return postedDate;
    }

    public int getLike() {
        return like;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
