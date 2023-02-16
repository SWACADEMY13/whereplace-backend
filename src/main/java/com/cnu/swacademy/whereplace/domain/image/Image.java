package com.cnu.swacademy.whereplace.domain.image;

import com.cnu.swacademy.whereplace.domain.post_image.PostImage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;

    @Column(name = "image", nullable = false, length = 500)
    private String image;

    @OneToOne(mappedBy = "image")
    private PostImage postImage;
}
