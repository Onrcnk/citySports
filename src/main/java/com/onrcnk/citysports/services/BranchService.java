package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.BranchCommand;

import java.util.Set;

public interface BranchService {

    Set<BranchCommand> getAllFacilities();
    Set<BranchCommand> getBranchFromSportCenter(String id);
}
