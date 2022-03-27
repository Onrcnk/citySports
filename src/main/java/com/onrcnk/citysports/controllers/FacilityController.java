package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.services.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @RequestMapping("/facilities")
    public String getFacilityList(Model model){

        Set<Facility> facilitySet = facilityService.getFacilities();
        model.addAttribute("facilities", facilitySet);

        return "showfacilities";
    }
}
