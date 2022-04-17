package com.onrcnk.citysports.commands;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class DayCommandList {

    public String dayName;
    public LocalDate date;
    public TimeCommandList time;
    public String status;
    public String dayAndTime;

}
