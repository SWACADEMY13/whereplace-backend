package com.cnu.swacademy.whereplace.domain.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    void deleteAllByPost_PostId(int postId);
}
