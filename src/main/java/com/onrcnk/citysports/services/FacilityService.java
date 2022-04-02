package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.FacilityCommand;

import java.util.List;

public interface FacilityService {

    List<FacilityCommand> getFacilitiesFromSportCenter(String id);

}
