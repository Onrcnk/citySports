package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.domain.ReservationStatus;
import com.onrcnk.citysports.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    Set<Reservation> findByUserAndStatus(User user, ReservationStatus reservationStatus);
    Set<Reservation> findByFacility(Facility facility);
    Reservation findByDateTimeAndFacility(String dateAndTime, Facility facility);
}
