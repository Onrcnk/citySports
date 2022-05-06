package com.onrcnk.citysports.commands;

import com.onrcnk.citysports.domain.Cart;
import com.onrcnk.citysports.domain.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class TimeCommand {

    public String time;
    public ReservationStatus status;
}
