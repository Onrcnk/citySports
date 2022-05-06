package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.DayCommand;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.commands.TimeCommand;
import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping("/reservation/{facilityId}")
    public String getReservationPage(@PathVariable String facilityId, Model model){

        Set<ReservationCommand> reservationCommands = reservationService.getReservation(facilityId);
        model.addAttribute("reservations",reservationCommands);

        return "reservation/reservationpage";
    }

    @PostMapping("/reservation/{facilityId}")
    public String addReservationToCart(@ModelAttribute TimeCommand timeCommand, @PathVariable String facilityId, Model model) {

            Set<ReservationCommand> reservationCommands = reservationService.setReservationToCart(timeCommand, facilityId);
            model.addAttribute("reservations",reservationCommands);

            return "/reservation/reservationpage";

    }

}
