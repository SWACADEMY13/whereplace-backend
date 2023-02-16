package com.cnu.swacademy.whereplace.domain.post_image;

import com.cnu.swacademy.whereplace.domain.image.Image;
import com.cnu.swacademy.whereplace.domain.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post_image")
public class PostImage {
    @Id
    private int postId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post postImage;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    private Image image;
}
