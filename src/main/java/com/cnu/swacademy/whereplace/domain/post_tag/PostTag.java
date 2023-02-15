package com.cnu.swacademy.whereplace.domain.post_tag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "post_tag")
public class PostTag {
    @Id
    private int postId;   // NOT NULL   fk, 연관관계 매핑 필요

    @Column(name = "tag_id", nullable = false)
    private int tagId;    // NOT NULL   fk, 연관관계 매핑 필요
}
