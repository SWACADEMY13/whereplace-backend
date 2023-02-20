package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.post_image.PostImage;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTag;
import com.cnu.swacademy.whereplace.domain.region.Region;
import com.cnu.swacademy.whereplace.domain.user.User;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    private Region region;

    @Builder.Default
    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "postTag", cascade = CascadeType.ALL)
    private List<PostTag> tags = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "postImage", cascade = CascadeType.ALL)
    private List<PostImage> images = new ArrayList<>();

//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public void setLike(int postLike) {
//        this.postLike = postLike;
//    }

//    public void setRegionId(int regionId) { // 수정 필요
//        this.regionId = regionId;
//    }


    // 글쓰기 임시 test용
    @Override
    public String toString() {
        return "Post{" + "id=" + postId + ", content='" + content + '\'' + '}';
    } // 수정 필요,,,
}
