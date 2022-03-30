package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.commands.SportCenterCommand;

import java.util.Set;

public interface FacilityService {

    Set<FacilityCommand> getFacilities();
    Set<SportCenterCommand> getFacilitiesFromSportCenter();

}
