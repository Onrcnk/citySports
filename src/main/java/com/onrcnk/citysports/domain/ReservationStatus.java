package com.onrcnk.citysports.domain;

import lombok.Getter;

@Getter
public enum ReservationStatus {
    RESERVE( "RESERVE"),
    RESERVED( "RESERVED"),
    INTHECART("CARTED"),
    UNAVAILABLE("UNAVAILABLE"),
    ;

    private String description;

    ReservationStatus(String description) {
        this.description = description;
    }
}
