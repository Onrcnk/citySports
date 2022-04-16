package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.domain.Branch;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.mappers.BranchMapper;
import com.onrcnk.citysports.mappers.FacilityMapper;
import com.onrcnk.citysports.repositories.BranchRepository;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import com.onrcnk.citysports.services.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class FacilityServiceImp implements FacilityService {

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
    public Set<FacilityCommand> getAllFacilities() {
        Set<FacilityCommand> facilityCommands = new LinkedHashSet<>();
        List<Facility> facilities = facilityRepository.findAll();

        for(Facility facility : facilities){
            facilityCommands.add(facilityMapper.facilityToFacilityCommand(facility));
        }
        return facilityCommands;

    }

    @Override
    public Set<FacilityCommand> getFacilityFromSportCenterAndBranch(String branchId, String sportCenterId) {

        Optional<Branch> branches = branchRepository.findById(branchId);
        Set<Facility> facilitySet = branches.get().getFacilitySet();
        Set<FacilityCommand> facilityCommands = new LinkedHashSet<>();

        for(Facility facility:facilitySet){
            if(facility.getSportsCenter().getSportCenterId().equals(sportCenterId)) {
                FacilityCommand facilityCommand = facilityMapper.facilityToFacilityCommand(facility);
                facilityCommands.add(facilityCommand);
            }
        }
        return facilityCommands;
    }

    @Override
    public Set<FacilityCommand> getFacilityFromBranchAndSportCenter(String branchId, String sportCenterId) {

        Optional<Branch> branches = branchRepository.findById(branchId);
        Set<Facility> facilitySet = branches.get().getFacilitySet();
        Set<FacilityCommand> facilityCommands = new LinkedHashSet<>();

        for(Facility facility:facilitySet){
            if(facility.getSportsCenter().getSportCenterId().equals(sportCenterId)) {
                FacilityCommand facilityCommand = facilityMapper.facilityToFacilityCommand(facility);
                facilityCommands.add(facilityCommand);
            }
        }
        return facilityCommands;
    }


}
