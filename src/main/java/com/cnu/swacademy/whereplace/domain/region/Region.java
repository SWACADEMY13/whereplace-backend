package com.cnu.swacademy.whereplace.domain.region;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class Region {
    @Id
    private int regionId;         // NOT NULL
    private String regionName;    // NOT NULL

    public int getRegionId() {
        return regionId;
    }

    public String getRegionName() {
        return regionName;
    }
}
