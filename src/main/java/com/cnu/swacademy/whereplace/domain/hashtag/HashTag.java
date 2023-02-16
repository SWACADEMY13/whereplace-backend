package com.cnu.swacademy.whereplace.domain.hashtag;

import com.cnu.swacademy.whereplace.domain.post_tag.PostTag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hashtag")
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tagId;

    @Column(name = "tag_name", nullable = false, length = 45)
    private String tagName;

    @OneToMany(mappedBy = "hashTag")
    private List<PostTag> postTags = new ArrayList<>();
}
