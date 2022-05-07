package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.domain.MyUserDetails;
import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(Email);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + Email));

        return user.map(MyUserDetails::new).get();

    }

}
