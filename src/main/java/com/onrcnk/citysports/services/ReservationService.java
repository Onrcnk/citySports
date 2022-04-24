package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.ReservationCommand;

import java.util.Set;

public interface ReservationService {

    Set<ReservationCommand> getReservation(String facilityId);
}
