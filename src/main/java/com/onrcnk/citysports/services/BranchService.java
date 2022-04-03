package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.FacilityCommand;

import java.util.List;

public interface BranchService {

    List<FacilityCommand> getFacilityFromBranch(String id, String sportCenterId);
}
