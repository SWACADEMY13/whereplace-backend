package com.cnu.swacademy.whereplace.domain.region;

public class Region {
    private final int regionId;         // NOT NULL
    private final String regionName;    // NOT NULL

    public Region(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public int getRegionId() {
        return regionId;
    }

    public String getRegionName() {
        return regionName;
    }
}
