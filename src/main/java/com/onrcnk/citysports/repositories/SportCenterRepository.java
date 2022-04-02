package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.SportCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportCenterRepository extends JpaRepository<SportCenter, String> {

}
