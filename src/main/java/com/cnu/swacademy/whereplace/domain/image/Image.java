package com.cnu.swacademy.whereplace.domain.image;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "image")
public class Image {
    @Id
    private int imageId;  // NOT NULL

    @Column(name = "image", nullable = false, length = 500)
    private String image; // NOT NULL
}
