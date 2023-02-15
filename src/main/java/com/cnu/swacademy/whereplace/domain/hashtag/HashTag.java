package com.cnu.swacademy.whereplace.domain.hashtag;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "hashtag")
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tagId;        // NOT NULL

    @Column(name = "tag_name", nullable = false, length = 45)
    private String tagName;   // NOT NULL
}
