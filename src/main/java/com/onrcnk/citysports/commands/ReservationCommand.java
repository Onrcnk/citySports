package com.onrcnk.citysports.commands;

import com.onrcnk.citysports.domain.Cart;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationCommand {

    private String reservationId;
    private Facility facility;
    private User user;
    private Cart cart;
    private String date;
    private String time;
    public DayCommandList dayCommandList;
    private String reservationStatus;
}
