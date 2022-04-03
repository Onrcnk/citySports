package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.BranchCommand;

import java.util.List;

public interface FacilityService {

    List<BranchCommand> getBranchFromSportCenter(String id);

}
