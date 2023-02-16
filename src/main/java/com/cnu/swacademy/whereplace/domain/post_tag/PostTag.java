package com.cnu.swacademy.whereplace.domain.post_tag;

import com.cnu.swacademy.whereplace.domain.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_tag")
public class PostTag {
    @Id
    private int postId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post postTag;

    @Column(name = "tag_id", nullable = false)
    private int tagId;    // NOT NULL   fk, 연관관계 매핑 필요
}
