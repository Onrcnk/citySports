package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.domain.Branch;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.mappers.FacilityMapper;
import com.onrcnk.citysports.repositories.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class BranchServiceImp implements BranchService{

    private  final BranchRepository branchRepository;
    private final FacilityMapper facilityMapper;

    public BranchServiceImp(BranchRepository branchRepository, FacilityMapper facilityMapper) {
        this.branchRepository = branchRepository;
        this.facilityMapper = facilityMapper;
    }

    @Override
    public List<FacilityCommand> getFacilityFromBranch(String id, String sportCenterId) {

        Optional<Branch> branches = branchRepository.findById(id);
        Set<Facility> facilitySet = branches.get().getFacilitySet();
        List<FacilityCommand> facilityCommandList = new ArrayList<>();

        for(Facility facility:facilitySet){
            if(facility.getSportsCenter().getSportCenterId().equals(sportCenterId)) {
                FacilityCommand facilityCommand = facilityMapper.facilityToFacilityCommand(facility);
                facilityCommandList.add(facilityCommand);
            }
        }

        return facilityCommandList;
    }
}
