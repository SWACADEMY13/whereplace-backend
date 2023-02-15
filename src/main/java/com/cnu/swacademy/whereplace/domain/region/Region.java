package com.cnu.swacademy.whereplace.domain.region;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "region")
public class Region {
    @Id // fk, 연관관계 매핑 필요
    private int regionId;         // NOT NULL

    @Column(name = "region_name", nullable = false)
    private String regionName;    // NOT NULL
}
