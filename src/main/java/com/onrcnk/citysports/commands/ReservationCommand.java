package com.onrcnk.citysports.commands;

import com.onrcnk.citysports.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ReservationCommand {

    private String reservationId;
    private String facilityId;
    private User user;
    public DayCommand dayCommand;


}
