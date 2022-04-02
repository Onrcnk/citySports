package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.SportCenter;
import com.onrcnk.citysports.mappers.FacilityMapper;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class FacilityServiceImp implements FacilityService{

    private final FacilityRepository facilityRepository;
    private final SportCenterRepository sportCenterRepository;
    private final FacilityMapper facilityMapper;

    @Autowired
    public FacilityServiceImp(FacilityRepository facilityRepository,
                              SportCenterRepository sportCenterRepository,
                              FacilityMapper facilityMapper) {
        this.facilityRepository = facilityRepository;
        this.sportCenterRepository = sportCenterRepository;
        this.facilityMapper = facilityMapper;
    }


    @Override
    public List<FacilityCommand> getFacilitiesFromSportCenter(String id) {

        Optional<SportCenter> sportCenters = sportCenterRepository.findById(id);
        Set<Facility> facilityList = sportCenters.get().getFacilities();
        List<FacilityCommand> facilityCommandsList = new ArrayList<>();

        for(Facility facility : facilityList) {
            FacilityCommand facilityCommand = facilityMapper.facilityToFacilityCommand(facility);
            facilityCommandsList.add(facilityCommand);
        }


        return facilityCommandsList;
    }


}
