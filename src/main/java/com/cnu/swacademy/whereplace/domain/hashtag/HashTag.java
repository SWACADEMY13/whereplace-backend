package com.cnu.swacademy.whereplace.domain.hashtag;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hashtag")
public class HashTag {
    @Id
    private int tagId;        // NOT NULL
    private String tagName;   // NOT NULL

    public int getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }
}
