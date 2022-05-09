package com.onrcnk.citysports.commands;

import com.onrcnk.citysports.domain.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeCommand {

    public String time;
    public ReservationStatus status;
}
