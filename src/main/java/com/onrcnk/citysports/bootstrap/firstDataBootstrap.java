package com.onrcnk.citysports.bootstrap;

import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class firstDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    public firstDataBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        setData();
    }

    public void setData() {
        User upt = userRepository.findByEmail("dinç_oguz@hotmail.com");

        upt.setSurname("Direnç Dinç");

        userRepository.save(upt);


    }

}
