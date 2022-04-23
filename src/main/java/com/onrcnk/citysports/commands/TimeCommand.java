package com.onrcnk.citysports.commands;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeCommand {

    public LocalDateTime time;
    public boolean status;
}
