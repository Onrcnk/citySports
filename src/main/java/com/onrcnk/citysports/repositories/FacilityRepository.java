package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, String> {

    public List<Facility> findAllByOrderByFacilityNameAsc();
}
