package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.DayAndTimeListCommand;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping("/reservation")
    public String getReservationPage(Model model){

        Set<DayAndTimeListCommand> dayAndTimeListCommands = reservationService.getReservation();
        model.addAttribute("reservations",dayAndTimeListCommands);

        return "reservationpage";
    }
}
