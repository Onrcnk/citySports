package com.onrcnk.citysports.domain;

import lombok.Getter;

@Getter
public enum ReservationStatus {
    RESERVE( "RESERVE"),
    RESERVED( "RESERVED"),
    INTHECART("In_The_Cart"),
    UNAVAILABLE("UNAVAILABLE"),
    ;

    private String description;

    ReservationStatus(String description) {
        this.description = description;
    }
}
