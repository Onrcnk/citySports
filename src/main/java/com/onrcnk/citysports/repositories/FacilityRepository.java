package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, String> {
    Facility findByFacilityId(String facilityId);
}
