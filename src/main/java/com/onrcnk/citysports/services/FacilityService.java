package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.FacilityCommand;

import java.util.Set;

public interface FacilityService {

    Set<FacilityCommand> getFacilities();

}
