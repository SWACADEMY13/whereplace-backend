package com.cnu.swacademy.whereplace.domain.post_tag;

public class PostTag {
    private final int postId;   // NOT NULL
    private final int tagId;    // NOT NULL

    public PostTag(int postId, int tagId) {
        this.postId = postId;
        this.tagId = tagId;
    }

    public int getPostId() {
        return postId;
    }

    public int getTagId() {
        return tagId;
    }
}
