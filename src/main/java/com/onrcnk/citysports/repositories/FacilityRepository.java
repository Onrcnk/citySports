package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.SportCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, String> {

    List<Facility> findAllByOrderByFacilityNameAsc();

    @Query("select facility from Facility facility WHERE facility.sportsCenter.sportsCenterId =:id ")
    List<Facility> findAllBySportCenterId(String id);

}
