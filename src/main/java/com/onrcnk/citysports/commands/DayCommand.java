package com.onrcnk.citysports.commands;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DayCommand {

    public String dayName;
    public Set<TimeCommand> timeCommand;

}
