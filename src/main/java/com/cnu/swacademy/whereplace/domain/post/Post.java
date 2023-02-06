package com.cnu.swacademy.whereplace.domain.post;

import java.time.LocalDateTime;

public class Post {
    private final int postId;               // NOT NULL
    private final String userId;            // NOT NULL
    private String content;                 // NULLABLE
    private final LocalDateTime postedDate; // NOT NULL
    private int like;                       // NOT NULL
    private int regionId;                   // NOT NULL

    public Post(int postId, String userId, String content, LocalDateTime postedDate, int like, int regionId) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.postedDate = postedDate;
        this.like = like;
        this.regionId = regionId;
    }

    public void like() {
        this.like++;
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

    public int getRegionId() {
        return regionId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
