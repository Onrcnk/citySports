package com.onrcnk.citysports.repositories;

import com.onrcnk.citysports.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);
}