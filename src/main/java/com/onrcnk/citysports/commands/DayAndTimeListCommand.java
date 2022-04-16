package com.onrcnk.citysports.commands;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DayAndTimeListCommand {

    public String dayName;
    public LocalDateTime dayAndTime;
    public String status;

}
