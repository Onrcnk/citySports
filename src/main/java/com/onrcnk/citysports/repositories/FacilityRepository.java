package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, String> {

}
