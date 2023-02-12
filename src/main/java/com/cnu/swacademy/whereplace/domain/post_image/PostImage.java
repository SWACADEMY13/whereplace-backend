package com.cnu.swacademy.whereplace.domain.post_image;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_image")
public class PostImage {
    @Id
    private int postId;   // NOT NULL
    private int imageId;  // NOT NULL

    public int getPostId() {
        return postId;
    }

    public int getImageId() {
        return imageId;
    }
}
