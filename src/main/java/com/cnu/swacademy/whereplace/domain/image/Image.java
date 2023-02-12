package com.cnu.swacademy.whereplace.domain.image;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "image")
public class Image {
    @Id
    private int imageId;  // NOT NULL
    private String image; // NOT NULL

    public int getImageId() {
        return imageId;
    }

    public String getImage() {
        return image;
    }
}
