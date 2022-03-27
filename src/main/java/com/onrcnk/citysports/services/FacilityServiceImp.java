package com.onrcnk.citysports.services;

import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.repositories.FacilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class FacilityServiceImp implements FacilityService{

    private final FacilityRepository facilityRepository;

    public FacilityServiceImp(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Set<Facility> getFacilities() {

        Set<Facility> facilitySet = new HashSet<>();
        facilityRepository.findAll().iterator().forEachRemaining(facilitySet::add);
        return facilitySet;

    }

}
