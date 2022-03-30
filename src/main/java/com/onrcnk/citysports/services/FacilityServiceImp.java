package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.commands.SportCenterCommand;
import com.onrcnk.citysports.converters.FacilityToFacilityCommand;
import com.onrcnk.citysports.converters.SportCenterToSportCenterCommand;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.SportCenter;
import com.onrcnk.citysports.repositories.FacilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class FacilityServiceImp implements FacilityService{

    private final FacilityRepository facilityRepository;
    private final FacilityToFacilityCommand facilityToFacilityCommand;
    private final SportCenterToSportCenterCommand sportCenterToSportCenterCommand;

    public FacilityServiceImp(FacilityRepository facilityRepository, FacilityToFacilityCommand facilityToFacilityCommand, SportCenterToSportCenterCommand sportCenterToSportCenterCommand) {
        this.facilityRepository = facilityRepository;
        this.facilityToFacilityCommand = facilityToFacilityCommand;
        this.sportCenterToSportCenterCommand = sportCenterToSportCenterCommand;
    }

    @Override
    public Set<FacilityCommand> getFacilities() {

        Set<FacilityCommand> facilityCommandSet = new LinkedHashSet<>();
        List<Facility> facilitySet = facilityRepository.findAllByOrderByFacilityNameAsc();

        for(Facility facility : facilitySet){
            facilityCommandSet.add(facilityToFacilityCommand.convert(facility));
        }

        return facilityCommandSet;

    }

    @Override
    public Set<SportCenterCommand> getFacilitiesFromSportCenter() {

        Set<SportCenterCommand> sportCenterCommandSet = new LinkedHashSet<>();
        List<Facility> sportCenters = facilityRepository.findAllBySportCenterId("753da086-5453-4a27-baaa-6284c7a2931c");

        return sportCenterCommandSet;

    }


}
