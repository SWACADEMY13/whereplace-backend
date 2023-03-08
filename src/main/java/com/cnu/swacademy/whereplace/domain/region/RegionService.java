package com.cnu.swacademy.whereplace.domain.region;

import org.springframework.stereotype.Service;

@Service
public class RegionService {
    public Region find(int regionId) {
        return null;
    }

    public static RegionDto.Response toDto(Region region) {
        return RegionDto.Response.builder()
                .regionId(region.getRegionId())
                .regionName(region.getRegionName())
                .build();
    }
}
