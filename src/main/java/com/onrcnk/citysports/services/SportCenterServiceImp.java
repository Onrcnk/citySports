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

    private final SportCenterRepository sportCenterRepository;
    private final SportCenterToSportCenterCommand sportCenterToSportCenterCommand;

    public SportCenterServiceImp(SportCenterRepository sportCenterRepository, SportCenterToSportCenterCommand sportCenterToSportCenterCommand) {
        this.sportCenterRepository = sportCenterRepository;
        this.sportCenterToSportCenterCommand = sportCenterToSportCenterCommand;
    }

    @Override
    public Set<SportCenterCommand> getSportCenter() {

//        Set<SportCenterCommand> sportCenterCommands = new LinkedHashSet<>();
//        List<SportCenter> sportCenters = sportCenterRepository.findAllByOrderBySportsCenterAsc();
//
//        for(SportCenter sportCenter : sportCenters){
//            sportCenterCommands.add(sportCenterToSportCenterCommand.convert(sportCenter));
//        }

        return null;

    }
}
