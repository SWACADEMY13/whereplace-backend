package com.cnu.swacademy.whereplace.domain.region;

import com.cnu.swacademy.whereplace.domain.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int regionId;

    @Column(name = "region_name", nullable = false)
    private String regionName;

    @OneToMany(mappedBy = "region_id")
    private List<Post> posts = new ArrayList<>();
}
