package com.onrcnk.citysports.commands;

import com.onrcnk.citysports.domain.Cart;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationCommand {

    private String reservationId;
    private Facility facility;
    private User user;
    private Cart cart;
    public DayCommand dayCommand;


}
