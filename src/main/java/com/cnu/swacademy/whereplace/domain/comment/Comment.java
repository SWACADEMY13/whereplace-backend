package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@DynamicInsert
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private int commentId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post commentedPost;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User commentedUser;

    @Column(name = "content", nullable = false, length = 200)
    private String content;

    @Column(name = "posted_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime postedDate;

    @Column(name = "comment_like", nullable = false)
    @ColumnDefault("0")
    private int commentLike;

    public void setPostedDate(LocalDateTime postedDate){
        this.postedDate = postedDate;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setCommentLike(int commentLike) {
        this.commentLike = commentLike;
    }

    public void setMappingInfo(Post commentedPost, User commentedUser){
        setCommentedUser(commentedUser);
        setCommentedPost(commentedPost);
    }

    private void setCommentedPost(Post commentedPost) {
        this.commentedPost = commentedPost;
    }

    private void setCommentedUser(User commentedUser) {
        this.commentedUser = commentedUser;
    }
}