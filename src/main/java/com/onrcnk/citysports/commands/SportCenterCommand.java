package com.onrcnk.citysports.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportCenterCommand {

    private String id;
    private String sportCenterName;
    private String facilityName;
    private String facilityNames = "";
}
