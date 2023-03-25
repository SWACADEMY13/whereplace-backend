package com.cnu.swacademy.whereplace.domain.image;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.region.Region;
import com.cnu.swacademy.whereplace.domain.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public Image create(Post post, ImageDto.Request dto) {
        Image image = dto.toEntity();
        image.setPost(post);

        return imageRepository.save(image);
    }

    @Transactional
    public void delete(Post post) {
        imageRepository.deleteAllByPost_PostId(post.getPostId());
    }

    public static ImageDto.Response toDto(Image image) {
        return ImageDto.Response.builder()
                .imageId(image.getImageId())
                .image(image.getImage()).build();
    }
}
