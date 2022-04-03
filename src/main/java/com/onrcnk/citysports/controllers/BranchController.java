package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.services.BranchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @RequestMapping("/facilitylist/{branchId}/{sportCenterId}")
    public String getFacilityListFromBranch(@PathVariable String branchId, @PathVariable String sportCenterId, Model model){

        List<FacilityCommand> facilityCommands = branchService.getFacilityFromBranch(branchId, sportCenterId);
        model.addAttribute("facilities", facilityCommands);
        return "sportcenter/facilitieslist";
    }
}
