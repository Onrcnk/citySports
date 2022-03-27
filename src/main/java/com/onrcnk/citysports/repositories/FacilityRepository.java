package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface FacilityRepository extends CrudRepository<Facility, String> {
}
