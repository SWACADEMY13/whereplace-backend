package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.post_tag.PostTag;
import com.cnu.swacademy.whereplace.domain.region.Region;
import com.cnu.swacademy.whereplace.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;               // NOT NULL

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User postedUser;            // NOT NULL

    @Column(name = "content", length = 1000)
    private String content;                 // NULLABLE

    @Column(name = "posted_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime postedDate; // NOT NULL

    @Column(name = "like", nullable = false)
    @ColumnDefault("0")
    private int like;                       // NOT NULL

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;                   // NOT NULL


//    @OneToMany(mappedBy = "postComment")
//    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "postTag")
    private List<PostTag> tags = new ArrayList<>();

    public void setContent(String content) {
        this.content = content;
    }

    public void setLike(int like) {
        this.like = like;
    }

//    public void setRegionId(int regionId) { // 수정 필요
//        this.regionId = regionId;
//    }

    @Override
    public String toString() {
        return "Post{" + "id=" + postId + ", content='" + content + '\'' + '}';
    }
}
