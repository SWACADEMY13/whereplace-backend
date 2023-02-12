package com.cnu.swacademy.whereplace.domain.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {
    @Id
    private int postId;               // NOT NULL
    private String userId;            // NOT NULL
    private String content;                 // NULLABLE
    private LocalDateTime postedDate; // NOT NULL
    private int like;                       // NOT NULL
    private int regionId;                   // NOT NULL

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

    public int getRegionId() {
        return regionId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
