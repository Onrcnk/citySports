package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.services.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class FacilityController {

    private final FacilityService facilityService;
    private final FacilityRepository facilityRepository;

    public FacilityController(FacilityService facilityService, FacilityRepository facilityRepository) {
        this.facilityService = facilityService;
        this.facilityRepository = facilityRepository;
    }


//    public String getFacilityList(Model model){
//        Set<FacilityCommand> facilitySet = facilityService.getFacilities();
//        model.addAttribute("facilities", facilitySet);
//        return "showfacilities";
//    }

    @RequestMapping("/facilities")
    public String getFacilityPage(Model model){

        return "showfacilitiesnew";
    }


}
