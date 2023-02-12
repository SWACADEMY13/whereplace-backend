package com.cnu.swacademy.whereplace.domain.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    private int commentId;            // NOT NULL
    private int postId;               // NOT NULL
    private String userId;            // NOT NULL
    private String content;                 // NOT NULL
    private LocalDateTime postedDate; // NOT NULL
    private int like;

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

    public void setLike(int like) {
        this.like = like;
    }
}
