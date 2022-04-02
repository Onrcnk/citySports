package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.SportCenterCommand;
import com.onrcnk.citysports.domain.SportCenter;
import com.onrcnk.citysports.mappers.SportCenterMapper;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class SportCenterServiceImp implements SportCenterService{

    private final SportCenterRepository sportCenterRepository;
    private final SportCenterMapper sportCenterMapper;

    @Autowired
    public SportCenterServiceImp(SportCenterRepository sportCenterRepository,
                                 SportCenterMapper sportCenterMapper) {
        this.sportCenterRepository = sportCenterRepository;
        this.sportCenterMapper = sportCenterMapper;
    }

    @Override
    public Set<SportCenterCommand> getAllSportCenter() {
        Set<SportCenterCommand> sportCenterCommands = new LinkedHashSet<>();
        List<SportCenter> sportCenters = sportCenterRepository.findAll();

        for(SportCenter sportCenter : sportCenters){
            sportCenterCommands.add(sportCenterMapper.sportCenterToSportCenterCommand(sportCenter));
        }
        return sportCenterCommands;

    }
}
