package com.cnu.swacademy.whereplace.domain.post_image;

import com.cnu.swacademy.whereplace.domain.image.Image;
import com.cnu.swacademy.whereplace.domain.post.Post;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "post_image")
public class PostImage {
    @Id
    @Column(name = "post_id")
    private int postId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post postImage;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    private Image image;
}
