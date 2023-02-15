package com.cnu.swacademy.whereplace.domain.post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "post")
public class Post {
    @Id
    private int postId;               // NOT NULL

    @Column(name = "user_id", nullable = false, length = 20) // fk
    private String userId;            // NOT NULL

    @Column(name = "user_id", nullable = false, length = 20) // fk, 여기부터
    private String content;                 // NULLABLE
    private LocalDateTime postedDate; // NOT NULL
    private int like;                       // NOT NULL
    private int regionId;                   // NOT NULL

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
