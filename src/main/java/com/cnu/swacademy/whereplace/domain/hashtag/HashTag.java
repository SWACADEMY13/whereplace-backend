package com.cnu.swacademy.whereplace.domain.hashtag;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hashtag")
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tagId;        // NOT NULL

    @Column(name = "tag_name", nullable = false, length = 45)
    private String tagName;   // NOT NULL
}
