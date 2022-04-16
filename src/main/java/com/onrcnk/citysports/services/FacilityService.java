package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.FacilityCommand;

import java.util.Set;

public interface FacilityService {

    Set<FacilityCommand> getAllFacilities();
    Set<FacilityCommand> getFacilityFromSportCenterAndBranch(String branchId, String sportCenterId);
    Set<FacilityCommand> getFacilityFromBranchAndSportCenter(String branchId, String sportCenterId);

}
