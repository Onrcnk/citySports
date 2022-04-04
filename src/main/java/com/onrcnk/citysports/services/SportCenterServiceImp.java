package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.SportCenterCommand;
import com.onrcnk.citysports.domain.Branch;
import com.onrcnk.citysports.domain.SportCenter;
import com.onrcnk.citysports.mappers.SportCenterMapper;
import com.onrcnk.citysports.repositories.BranchRepository;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class SportCenterServiceImp implements SportCenterService{

    private final SportCenterRepository sportCenterRepository;
    private final SportCenterMapper sportCenterMapper;
    private final FacilityRepository facilityRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public SportCenterServiceImp(SportCenterRepository sportCenterRepository,
                                 SportCenterMapper sportCenterMapper, FacilityRepository facilityRepository, BranchRepository branchRepository) {
        this.sportCenterRepository = sportCenterRepository;
        this.sportCenterMapper = sportCenterMapper;
        this.facilityRepository = facilityRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Set<SportCenterCommand> getAllSportCenters() {
        Set<SportCenterCommand> sportCenterCommands = new LinkedHashSet<>();
        List<SportCenter> sportCenters = sportCenterRepository.findAll();

        for(SportCenter sportCenter : sportCenters){
            sportCenterCommands.add(sportCenterMapper.sportCenterToSportCenterCommand(sportCenter));
        }
        return sportCenterCommands;

    }

    @Override
    public Set<SportCenterCommand> getSportCenterFromBranch(String branchId) {

        Optional<Branch> branchOptional = branchRepository.findById(branchId);
        Set<SportCenter> sportCenterSet = branchOptional.get().getSportCenterSet();

        Set<SportCenterCommand> sportCenterCommands = new LinkedHashSet<>();

        for(SportCenter sportCenter : sportCenterSet) {
            SportCenterCommand sportCenterCommand = sportCenterMapper.sportCenterToSportCenterCommand(sportCenter);
            sportCenterCommand.setBranchId(branchId);
            sportCenterCommands.add(sportCenterCommand);
        }

        return sportCenterCommands;
    }


}
