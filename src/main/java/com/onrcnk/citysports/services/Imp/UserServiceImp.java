package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.repositories.UserRepository;
import com.onrcnk.citysports.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserServiceImp implements UserService{

    private  final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        User newUser = new User();

        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRoles("USER");

        userRepository.save(newUser);
    }

    @Override
    public String findUserId(String email) {
        return userRepository.findByEmail(email).get().getApplicationUserId();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

}
