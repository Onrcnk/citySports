package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.BranchCommand;
import com.onrcnk.citysports.domain.Branch;
import com.onrcnk.citysports.domain.SportCenter;
import com.onrcnk.citysports.mappers.BranchMapper;
import com.onrcnk.citysports.mappers.FacilityMapper;
import com.onrcnk.citysports.repositories.BranchRepository;
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
    private final BranchRepository branchRepository;
    private final FacilityMapper facilityMapper;
    private final BranchMapper branchMapper;

    @Autowired
    public FacilityServiceImp(FacilityRepository facilityRepository,
                              SportCenterRepository sportCenterRepository,
                              BranchRepository branchRepository, FacilityMapper facilityMapper, BranchMapper branchMapper) {
        this.facilityRepository = facilityRepository;
        this.sportCenterRepository = sportCenterRepository;
        this.branchRepository = branchRepository;
        this.facilityMapper = facilityMapper;
        this.branchMapper = branchMapper;
    }


    @Override
    public List<BranchCommand> getBranchFromSportCenter(String id) {

        Optional<SportCenter> sportCenters = sportCenterRepository.findById(id);
        Set<Branch> branchSet = sportCenters.get().getBranchSet();
        List<BranchCommand> branchCommandList = new ArrayList<>();

        for(Branch branch : branchSet) {
            BranchCommand branchCommand = branchMapper.branchToBranchComment(branch);
            branchCommand.setSportCenterId(id);
            branchCommandList.add(branchCommand);
        }

        return branchCommandList;
    }



}
