package com.cnu.swacademy.whereplace.domain.comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@DynamicInsert
@Getter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    private int commentId;            // NOT NULL

    @Column(name = "post_id", nullable = false) // fk
    private int postId;               // NOT NULL

    @Column(name = "user_id", nullable = false, length = 20) // fk
    private String userId;            // NOT NULL

    @Column(name = "content", nullable = false, length = 200)
    private String content;                 // NOT NULL

    @Column(name = "posted_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime postedDate; // NOT NULL

    @Column(name = "like", nullable = false, columnDefinition = "default 0")
    private int like;

    public void setContent(String content) {
        this.content = content;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
