package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.SportsCenter;
import com.onrcnk.citysports.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface SportsCenterRepository extends CrudRepository<SportsCenter, String> {
}
