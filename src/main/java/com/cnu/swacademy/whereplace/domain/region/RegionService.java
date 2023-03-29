package com.cnu.swacademy.whereplace.domain.region;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Region find(int regionId) {
        return regionRepository.findById(regionId).orElse(null);
    }

    public RegionDto.Response toDto(Region region) {
        Region pRegion = find(region.getRegionId());

        return RegionDto.Response.builder()
                .regionId(pRegion.getRegionId())
                .regionName(pRegion.getRegionName())
                .build();
    }
}
