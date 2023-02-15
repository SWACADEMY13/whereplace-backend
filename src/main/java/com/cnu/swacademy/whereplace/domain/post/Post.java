package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@Getter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;               // NOT NULL

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User posted_user;            // NOT NULL

    @Column(name = "content", length = 1000)
    private String content;                 // NULLABLE

    @Column(name = "posted_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime postedDate; // NOT NULL

    @Column(name = "like", nullable = false)
    @ColumnDefault("0")
    private int like;                       // NOT NULL

    @Column(name = "regionId", nullable = false) // fk, 연관관계 매핑 필요
    private int regionId;                   // NOT NULL

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

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
