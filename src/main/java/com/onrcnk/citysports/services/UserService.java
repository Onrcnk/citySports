package com.onrcnk.citysports.services;

import com.onrcnk.citysports.domain.User;

import java.security.Principal;
import java.util.Optional;

public interface UserService {

    void saveUser(User user);
    String findUserId(String email);
    User findByEmail(String email);
}
