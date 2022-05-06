package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.CartCommand;
import com.onrcnk.citysports.commands.DayCommand;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.commands.TimeCommand;
import com.onrcnk.citysports.domain.Cart;

import java.sql.Time;
import java.util.Set;

public interface ReservationService {

    Set<ReservationCommand> getReservation(String facilityId);
    Set<ReservationCommand> setReservationToCart(TimeCommand time, String facilityId);
}
