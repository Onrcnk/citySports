package com.onrcnk.citysports.mappers;

import com.onrcnk.citysports.commands.SportCenterCommand;
import com.onrcnk.citysports.domain.SportCenter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SportCenterMapper {

    @Mappings({
            @Mapping(target = "sportCenterId", source = "sportCenter.sportCenterId")
    })
    SportCenterCommand sportCenterToSportCenterCommand(SportCenter sportCenter);

}
