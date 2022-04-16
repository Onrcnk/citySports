package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.BranchCommand;
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
public class BranchController {

    private final BranchService branchService;
    private final FacilityService facilityService;

    public BranchController(BranchService branchService, FacilityService facilityService) {
        this.branchService = branchService;
        this.facilityService = facilityService;
    }

    @RequestMapping("/branches")
    public String getBranchPage(Model model){
        Set<BranchCommand> branchCommands = branchService.getAllFacilities();
        model.addAttribute("branches", branchCommands);
        return "branch/showbranches";
    }

    @RequestMapping("/branchlist/{sportCenterId}")
    public String getBranchListFromSportCenter(@PathVariable String sportCenterId, Model model) {

        Set<BranchCommand> branchCommand = branchService.getBranchFromSportCenter(sportCenterId);
        model.addAttribute("branches", branchCommand);
        return "branch/brancheslist";
    }
}
