package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.DayAndTimeListCommand;
import com.onrcnk.citysports.commands.ReservationCommand;

import java.util.Set;

public interface ReservationService {

    Set<DayAndTimeListCommand> getReservation();
}
