package com.cnu.swacademy.whereplace.domain.image;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;  // NOT NULL

    @Column(name = "image", nullable = false, length = 500)
    private String image; // NOT NULL
}
