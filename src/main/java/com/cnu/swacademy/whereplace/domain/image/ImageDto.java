package com.cnu.swacademy.whereplace.domain.image;

import lombok.*;


@Data
public class ImageDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private int imageId; // AUTO_INCREMENT
        private String image;

        // Dto -> Entity
        public Image toEntity() {
            return Image.builder()
                    .image(image)
                    .build();
        }
    }

    @Getter
    public static class Response{
        private int imageId;
        private String image;

        // Entity -> Dto
        public Response(Image image) {
            this.imageId = image.getImageId();
            this.image = image.getImage();
        }
    }
}
