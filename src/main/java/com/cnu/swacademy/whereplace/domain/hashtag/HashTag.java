package com.cnu.swacademy.whereplace.domain.hashtag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "hashtag")
public class HashTag {
    @Id
    private int tagId;        // NOT NULL

    @Column(name = "tag_name", nullable = false, length = 45)
    private String tagName;   // NOT NULL
}
