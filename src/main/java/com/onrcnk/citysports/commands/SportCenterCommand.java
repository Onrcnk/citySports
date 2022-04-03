package com.onrcnk.citysports.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportCenterCommand {

    private String sportCenterId;
    private String sportCenterName;
    private String branchId;
    private String facilityName;
    private String facilityNames = "";
}
