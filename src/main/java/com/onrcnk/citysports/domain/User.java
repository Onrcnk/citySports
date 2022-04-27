package com.onrcnk.citysports.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String applicationUserId;

    private String name;
    private String surname;
    private String password;
    private String birthDate;
    private String roles;

    @Column(unique = true)
    private String email;

    private Byte[] image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();

    @OneToOne
    private Cart cart;

    @OneToMany
    private Set<Reservation> reservationSet = new HashSet<>();

    @OneToMany
    private Set<FacilityScore> facilityScoreSet = new HashSet<>();

}
