package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.SportCenterCommand;
import com.onrcnk.citysports.converters.SportCenterToSportCenterCommand;
import com.onrcnk.citysports.domain.SportCenter;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class SportCenterServiceImp implements SportCenterService{

    SportCenterRepository sportCenterRepository;
    SportCenterToSportCenterCommand sportCenterToSportCenterCommand;


    @Override
    public Set<SportCenterCommand> getSportCenter() {

        Set<SportCenterCommand> sportCenterCommands = new LinkedHashSet<>();
        List<SportCenter> sportCenters = sportCenterRepository.findAllByOrderBySportCenterNameAsc();

        for(SportCenter sportCenter : sportCenters){
            sportCenterCommands.add(sportCenterToSportCenterCommand.convert(sportCenter));
        }

        return sportCenterCommands;

    }
}
