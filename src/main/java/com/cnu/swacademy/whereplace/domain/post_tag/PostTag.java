package com.cnu.swacademy.whereplace.domain.post_tag;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_tag")
public class PostTag {
    @Id
    private int postId;   // NOT NULL
    private int tagId;    // NOT NULL

    public int getPostId() {
        return postId;
    }

    public int getTagId() {
        return tagId;
    }
}
