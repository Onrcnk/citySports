package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.SportCenterCommand;

import java.util.Set;

public interface SportCenterService {

    Set<SportCenterCommand> getAllSportCenters();
    Set<SportCenterCommand> getSportCenterFromBranch(String branchId);
}
