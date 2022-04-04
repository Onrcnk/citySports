package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.BranchCommand;
import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.domain.Branch;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.SportCenter;
import com.onrcnk.citysports.mappers.BranchMapper;
import com.onrcnk.citysports.mappers.FacilityMapper;
import com.onrcnk.citysports.repositories.BranchRepository;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class BranchServiceImp implements BranchService{

    private  final BranchRepository branchRepository;
    private final FacilityMapper facilityMapper;
    private final SportCenterRepository sportCenterRepository;
    private final BranchMapper branchMapper;

    public BranchServiceImp(BranchRepository branchRepository, FacilityMapper facilityMapper, SportCenterRepository sportCenterRepository, BranchMapper branchMapper) {
        this.branchRepository = branchRepository;
        this.facilityMapper = facilityMapper;
        this.sportCenterRepository = sportCenterRepository;
        this.branchMapper = branchMapper;
    }

    @Override
    public Set<BranchCommand> getAllFacilities() {
        Set<BranchCommand> branchCommands = new LinkedHashSet<>();
        List<Branch> branches = branchRepository.findAll();

        for(Branch branch : branches){
            branchCommands.add(branchMapper.branchToBranchComment(branch));
        }
        return branchCommands;
    }

    @Override
    public Set<BranchCommand> getBranchFromSportCenter(String id) {

        Optional<SportCenter> sportCenters = sportCenterRepository.findById(id);
        Set<Branch> branchSet = sportCenters.get().getBranchSet();
        Set<BranchCommand> branchCommands = new LinkedHashSet<>();

        for(Branch branch : branchSet) {
            BranchCommand branchCommand = branchMapper.branchToBranchComment(branch);
            branchCommand.setSportCenterId(id);
            branchCommands.add(branchCommand);
        }

        return branchCommands;
    }
}
