package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.commands.TimeCommand;
import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.services.ReservationService;
import com.onrcnk.citysports.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Set;

@Slf4j
@Controller
public class ReservationController {

    private final ReservationService reservationService;
    private final UserService userService;

    public ReservationController(ReservationService reservationService, UserService userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @RequestMapping("/reservation/{facilityId}")
    public String getReservationPage(@PathVariable String facilityId, Model model){

        Set<ReservationCommand> reservationCommands = reservationService.getReservation(facilityId);
        model.addAttribute("reservations",reservationCommands);

        return "reservation/reservationpage";
    }

    @PostMapping("/reservation/{facilityId}")
    public String addReservationToCart(@ModelAttribute TimeCommand timeCommand, @PathVariable String facilityId,
                                       Model model, Principal principal) {

        User user = userService.findByEmail(principal.getName());
        Set<ReservationCommand> reservationCommands = reservationService.setReservationToCart(timeCommand, facilityId, user);
        model.addAttribute("reservations",reservationCommands);

        return "/reservation/reservationpage";

    }

}
