package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.image.Image;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTag;
import com.cnu.swacademy.whereplace.domain.region.Region;
import com.cnu.swacademy.whereplace.domain.user.User;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private int postId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User postedUser;

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "posted_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime postedDate;

    @Column(name = "post_like", nullable = false)
    @ColumnDefault("0")
    private int postLike;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Nullable
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;

    // 추가
    @Builder.Default
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostTag> postTags = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    public void setPostedUser(User postedUser) {
        this.postedUser = postedUser;
    }

    public void setPostedDate(LocalDateTime postedDate){
        this.postedDate = postedDate;
    }

    public void setContent(String content){
        this.content = content;
    }
}
