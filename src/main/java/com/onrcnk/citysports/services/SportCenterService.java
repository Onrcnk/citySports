package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.SportCenterCommand;

import java.util.List;
import java.util.Set;

public interface SportCenterService {

    Set<SportCenterCommand> getAllSportCenter();
    List<SportCenterCommand> getSportCenterFromBranch(String id);
}
