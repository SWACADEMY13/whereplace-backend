package com.cnu.swacademy.whereplace.domain.post_tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, Integer> {
    // 저장 전에 tagName 이 이미 존재하는지 확인해야 함.
}
