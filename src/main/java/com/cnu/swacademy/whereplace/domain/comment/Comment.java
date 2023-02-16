package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@DynamicInsert
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;            // NOT NULL

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post postComment;               // NOT NULL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User commentedUser;            // NOT NULL

    @Column(name = "content", nullable = false, length = 200)
    private String content;                 // NOT NULL

    @Column(name = "posted_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime postedDate; // NOT NULL

    @Column(name = "like", nullable = false)
    @ColumnDefault("0")
    private int like;

    public void setContent(String content) {
        this.content = content;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
