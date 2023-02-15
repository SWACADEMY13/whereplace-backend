package com.cnu.swacademy.whereplace.domain.post_image;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "post_image")
public class PostImage {
    @Id
    private int postId;   // NOT NULL   fk, 연관관계 매핑 필요

    @Column(name = "image_id", nullable = false)
    private int imageId;  // NOT NULL   fk, 연관관계 매핑 필요
}
