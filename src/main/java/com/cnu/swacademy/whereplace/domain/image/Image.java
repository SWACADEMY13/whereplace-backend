package com.cnu.swacademy.whereplace.domain.image;

public class Image {
    private final int imageId;  // NOT NULL
    private final String image; // NOT NULL

    public Image(int imageId, String image) {
        this.imageId = imageId;
        this.image = image;
    }

    public int getImageId() {
        return imageId;
    }

    public String getImage() {
        return image;
    }
}
