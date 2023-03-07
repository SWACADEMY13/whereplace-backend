package com.cnu.swacademy.whereplace.domain.hashtag;

import com.cnu.swacademy.whereplace.domain.post_tag.PostTag;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hashtag")
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private int tagId;

    @Column(name = "tag_name", nullable = false, length = 45)
    private String tagName;

//    @Builder.Default
//    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
//    private List<PostTag> postTags = new ArrayList<>();

    public void setTagName(String tagName){
        this.tagName=tagName;
    }
}
