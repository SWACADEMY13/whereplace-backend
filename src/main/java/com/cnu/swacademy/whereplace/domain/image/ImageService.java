package com.cnu.swacademy.whereplace.domain.image;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    public static ImageDto.Response toDto(Image image) {
        return ImageDto.Response.builder()
                .imageId(image.getImageId())
                .post(image.getPost())
                .image(image.getImage()).build();
    }
}
