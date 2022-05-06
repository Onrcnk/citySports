package com.onrcnk.citysports.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String reservationId;

    @ManyToOne
    private Facility facility;

    @ManyToOne
    private User user;

    @ManyToOne
    private Cart cart;

    private String facilityId;

    private String dayName;

    private String time;

    private String Status;

    public String dateAndTime;
    
}
