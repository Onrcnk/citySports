package com.onrcnk.citysports.services;

import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.commands.TimeCommand;
import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.domain.User;

import java.util.Set;

public interface ReservationService {

    Set<ReservationCommand> getReservation(String facilityId);
    Set<ReservationCommand> setReservationToCart(TimeCommand time, String facilityId, User user);
    Set<ReservationCommand> creatReservationCommandList(String facilityId);
    Reservation creatReservationObject(TimeCommand timeCommandReference, String facilityId, User user);
    Set<Reservation> getCartOfUser(User user);
    void setReservation(User user);
    Set<Reservation> getUserReservation(User user);
    Set<Reservation> deleteUserReservation(User user, String reservationId);
}
