package com.cnu.swacademy.whereplace.domain.region;

import org.springframework.stereotype.Service;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Region find(int regionId) {
        return regionRepository.findById(regionId).orElse(null);
    }

    public static RegionDto.Response toDto(Region region) {
        return RegionDto.Response.builder()
                .regionId(region.getRegionId())
                .regionName(region.getRegionName())
                .build();
    }
}
