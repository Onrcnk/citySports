package com.onrcnk.citysports.commands;

import com.onrcnk.citysports.domain.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CartCommand {

    public Set<ReservationCommand> reservationSet;
}
