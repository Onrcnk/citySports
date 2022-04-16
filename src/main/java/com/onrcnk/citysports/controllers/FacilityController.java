package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.services.BranchService;
import com.onrcnk.citysports.services.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class FacilityController {

    private final FacilityService facilityService;
    private final FacilityRepository facilityRepository;
    private final BranchService branchService;

    public FacilityController(FacilityService facilityService, FacilityRepository facilityRepository, BranchService branchService) {
        this.facilityService = facilityService;
        this.facilityRepository = facilityRepository;
        this.branchService = branchService;
    }

    @RequestMapping("/facilities")
    public String getFacilityPage(Model model){

        Set<FacilityCommand> facilityCommand = facilityService.getAllFacilities();
        model.addAttribute("facilities", facilityCommand);
        return "facility/showfacilities";
    }

    @RequestMapping("/facilitylist/{sportCenterId}/{branchId}")
    public String getFacilityFromSportCenterAndBranch(@PathVariable String branchId, @PathVariable String sportCenterId, Model model){

        Set<FacilityCommand> facilityCommands = facilityService.getFacilityFromSportCenterAndBranch(branchId, sportCenterId);
        model.addAttribute("facilities", facilityCommands);
        return "facility/facilitieslist";
    }

}
