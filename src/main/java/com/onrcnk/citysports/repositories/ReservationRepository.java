package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    Set<Reservation> findByFacilityId(String facilityId);
}
