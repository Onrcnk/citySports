package com.onrcnk.citysports.mappers;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.domain.Facility;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacilityMapper {

    FacilityCommand facilityToFacilityCommand(Facility facility);

}
