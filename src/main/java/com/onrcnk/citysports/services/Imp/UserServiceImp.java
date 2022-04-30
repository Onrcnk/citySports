package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.repositories.UserRepository;
import com.onrcnk.citysports.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImp implements UserService {

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
}
