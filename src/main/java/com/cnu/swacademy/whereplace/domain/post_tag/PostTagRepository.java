package com.cnu.swacademy.whereplace.domain.post_tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, Integer> {
    void deleteAllByPostTag_PostId(int postId);
}
