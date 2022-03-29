package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.SportCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportCenterRepository extends JpaRepository<SportCenter, String> {
    public List<SportCenter> findAllByOrderBySportCenterNameAsc();
}
