package com.cnu.swacademy.whereplace.domain.post_tag;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTag;
import com.cnu.swacademy.whereplace.domain.post.Post;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_tag")
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_tag_id")
    private int postTagId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post postTag;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    private HashTag hashTag;


    public PostTag(Post postTag, HashTag hashTag) {
        setMappingInfo(postTag,hashTag);
    }

    private void setMappingInfo(Post post, HashTag hashTag){
        this.postTag=post;
        this.hashTag=hashTag;

        this.getPostTag().getTags().add(this);
        this.getHashTag().getTags().add(this);
    }

}
