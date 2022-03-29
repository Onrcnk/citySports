package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import com.onrcnk.citysports.services.SportCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class SportCenterController {

    private final SportCenterService sportCenterService;
    private final SportCenterRepository sportCenterRepository;

    public SportCenterController(SportCenterService sportCenterService, SportCenterRepository sportCenterRepository) {
        this.sportCenterService = sportCenterService;
        this.sportCenterRepository = sportCenterRepository;
    }

    @RequestMapping("/sportcenters")
    public String getSportCenterPage(Model model){

        return "showsportcenters";
    }

}