package com.cnu.swacademy.whereplace.domain.image;

import com.cnu.swacademy.whereplace.domain.post_image.PostImage;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private int imageId;

    @Column(name = "image", nullable = false, length = 500)
    private String image;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private PostImage postImage;
}
