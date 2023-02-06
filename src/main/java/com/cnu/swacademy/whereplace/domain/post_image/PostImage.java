package com.cnu.swacademy.whereplace.domain.post_image;

public class PostImage {
    private final int postId;   // NOT NULL
    private final int imageId;  // NOT NULL

    public PostImage(int postId, int imageId) {
        this.postId = postId;
        this.imageId = imageId;
    }

    public int getPostId() {
        return postId;
    }

    public int getImageId() {
        return imageId;
    }
}
