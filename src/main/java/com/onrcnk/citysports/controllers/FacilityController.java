package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.BranchCommand;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.services.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
public class FacilityController {

    private final FacilityService facilityService;
    private final FacilityRepository facilityRepository;

    public FacilityController(FacilityService facilityService, FacilityRepository facilityRepository) {
        this.facilityService = facilityService;
        this.facilityRepository = facilityRepository;
    }

    @RequestMapping("/branches")
    public String getFacilityPage(Model model){

        return "showbranches";
    }

    @RequestMapping("/branchlist/{sportCenterId}")
    public String getBranchListFromSportCenter(@PathVariable String sportCenterId, Model model){

        List<BranchCommand> branchCommand = facilityService.getBranchFromSportCenter(sportCenterId);
        model.addAttribute("branches", branchCommand);
        return "sportcenter/brancheslist";
    }

}
