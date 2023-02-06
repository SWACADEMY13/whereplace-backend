package com.cnu.swacademy.whereplace.domain.hashtag;

public class HashTag {
    private final int tagId;        // NOT NULL
    private final String tagName;   // NOT NULL

    public HashTag(int tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public int getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }
}
