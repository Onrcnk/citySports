package com.onrcnk.citysports.bootstrap;

import com.onrcnk.citysports.domain.*;
import com.onrcnk.citysports.repositories.BranchRepository;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import com.onrcnk.citysports.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Component
public class FirstDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final FacilityRepository facilityRepository;
    private final SportCenterRepository sportCenterRepository;

    public FirstDataBootstrap(UserRepository userRepository, BranchRepository branchRepository, FacilityRepository facilityRepository, SportCenterRepository sportsCenterRepository) {
        this.userRepository = userRepository;
        this.branchRepository = branchRepository;
        this.facilityRepository = facilityRepository;
        this.sportCenterRepository = sportsCenterRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(userRepository.count()==0) {
            try {
                setData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void setData() throws IOException {

        User oguz = new User();
        User burak = new User();
        User onurcan = new User();

        oguz.setName("Oğuz");
        oguz.setSurname("Direnç Dinç");
        oguz.setPassword("3152");
        oguz.setEmail("dinc.oguz@hotmail.com");
        oguz.setRoles("USER");

        burak.setName("Burak");
        burak.setSurname("Topçu");
        burak.setPassword("1234");
        burak.setEmail("topcu.burak@hotmail.com");
        burak.setRoles("USER");

        onurcan.setName("Onurcan");
        onurcan.setSurname("KURT");
        onurcan.setPassword("9090");
        onurcan.setEmail("kurt.onurcan@hotmail.com");
        onurcan.setRoles("USER");

        SportCenter izmir = new SportCenter();
        SportCenter istanbul = new SportCenter();
        SportCenter samsun = new SportCenter();

        Branch basketball = new Branch();
        Branch volleyball = new Branch();
        Branch tennis = new Branch();
        Branch boxing = new Branch();
        Branch football = new Branch();

        Facility multiFunctionalFacility = new Facility();
        Facility tennisCourt = new Facility();
        Facility tennisCourt2 = new Facility();
        Facility tennisCourt3 = new Facility();
        Facility boxingRing = new Facility();
        Facility footballField = new Facility();
        Facility footballField2 = new Facility();
        Facility multiFunctionalFacility2 = new Facility();

        football.setBranchName("Football");
        boxing.setBranchName("Box");
        tennis.setBranchName("Tennis");
        volleyball.setBranchName("Volleyball");
        basketball.setBranchName("Basketball");

        izmir.setSportCenterName("Izmir Sports Center");
        istanbul.setSportCenterName("Istanbul Sports Center");
        samsun.setSportCenterName("Samsun Sports Center");

        InputStream in1 = FirstDataBootstrap.class.getResourceAsStream("/static/images/basket_court.jpg");
        byte[] basket_image = in1.readAllBytes();

        InputStream in2 = FirstDataBootstrap.class.getResourceAsStream("/static/images/boxing_ring.jpg");
        byte[] boxing_image = in2.readAllBytes();

        InputStream in3 = FirstDataBootstrap.class.getResourceAsStream("/static/images/football_field.jpg");
        byte[] football_image = in3.readAllBytes();

        InputStream in4 = FirstDataBootstrap.class.getResourceAsStream("/static/images/tennis_court.jpg");
        byte[] tennis_image = in4.readAllBytes();

        InputStream in5 = FirstDataBootstrap.class.getResourceAsStream("/static/images/volleyball_field.jpg");
        byte[] volleyball_image = in5.readAllBytes();

        InputStream in6 = FirstDataBootstrap.class.getResourceAsStream("/static/images/istanbul_sport_center.jpg");
        byte[] istanbul_image = in6.readAllBytes();

        InputStream in7 = FirstDataBootstrap.class.getResourceAsStream("/static/images/istanbul_sport_center.jpg");
        byte[] izmir_image = in7.readAllBytes();

        InputStream in8 = FirstDataBootstrap.class.getResourceAsStream("/static/images/samsun_sport_center.jpg");
        byte[] samsun_image = in8.readAllBytes();

        istanbul.setImage(Base64.getEncoder().encodeToString(istanbul_image));
        izmir.setImage(Base64.getEncoder().encodeToString(izmir_image));
        samsun.setImage(Base64.getEncoder().encodeToString(samsun_image));

        Set<Reservation> reservationSetOguz = new HashSet<>();
        Set<Reservation> reservationSetBurak = new HashSet<>();
        Set<Reservation> reservationSetOnurcan = new HashSet<>();
        oguz.setReservationSet(reservationSetOguz);
        burak.setReservationSet(reservationSetBurak);
        onurcan.setReservationSet(reservationSetOnurcan);

        football.setImage(Base64.getEncoder().encodeToString(football_image));
        boxing.setImage(Base64.getEncoder().encodeToString(boxing_image));
        tennis.setImage(Base64.getEncoder().encodeToString(tennis_image));
        volleyball.setImage(Base64.getEncoder().encodeToString(basket_image));
        basketball.setImage(Base64.getEncoder().encodeToString(basket_image));

        footballField.setFacilityName("Istanbul Football Field");
        footballField.setSportsCenter(istanbul);
        footballField.setImage(Base64.getEncoder().encodeToString(football_image));

        boxingRing.setFacilityName("Samsun Boxing Ring");
        boxingRing.setSportsCenter(samsun);
        boxingRing.setImage(Base64.getEncoder().encodeToString(boxing_image));

        tennisCourt.setFacilityName("Istanbul Tennis Court");
        tennisCourt.setSportsCenter(istanbul);
        tennisCourt.setImage(Base64.getEncoder().encodeToString(tennis_image));

        multiFunctionalFacility.setFacilityName("Istanbul Basketball and Volleyball Field");
        multiFunctionalFacility.setSportsCenter(istanbul);
        multiFunctionalFacility.setImage(Base64.getEncoder().encodeToString(basket_image));

        multiFunctionalFacility2.setFacilityName("Izmir Volleyball and Football Field");
        multiFunctionalFacility2.setSportsCenter(izmir);
        multiFunctionalFacility2.setImage(Base64.getEncoder().encodeToString(volleyball_image));

        footballField2.setFacilityName("Samsun Football Field");
        footballField2.setSportsCenter(samsun);
        footballField2.setImage(Base64.getEncoder().encodeToString(football_image));

        tennisCourt2.setFacilityName("Izmir Tennis Court");
        tennisCourt2.setSportsCenter(izmir);
        tennisCourt2.setImage(Base64.getEncoder().encodeToString(tennis_image));

        tennisCourt3.setFacilityName("Izmır Tennis Court - 2");
        tennisCourt3.setSportsCenter(izmir);
        tennisCourt3.setImage(Base64.getEncoder().encodeToString(tennis_image));

        sportCenterRepository.save(izmir);
        sportCenterRepository.save(istanbul);
        sportCenterRepository.save(samsun);

        facilityRepository.save(multiFunctionalFacility);
        facilityRepository.save(tennisCourt);
        facilityRepository.save(tennisCourt2);
        facilityRepository.save(tennisCourt3);
        facilityRepository.save(boxingRing);
        facilityRepository.save(footballField);
        facilityRepository.save(multiFunctionalFacility2);
        facilityRepository.save(footballField2);

        football.getFacilitySet().add(footballField);
        football.getFacilitySet().add(footballField2);
        boxing.getFacilitySet().add(boxingRing);
        tennis.getFacilitySet().add(tennisCourt);
        tennis.getFacilitySet().add(tennisCourt2);
        tennis.getFacilitySet().add(tennisCourt3);
        basketball.getFacilitySet().add(multiFunctionalFacility);
        volleyball.getFacilitySet().add(multiFunctionalFacility);
        volleyball.getFacilitySet().add(multiFunctionalFacility2);
        football.getFacilitySet().add(multiFunctionalFacility2);

        basketball.getSportCenterSet().add(istanbul);
        volleyball.getSportCenterSet().add(izmir);
        volleyball.getSportCenterSet().add(istanbul);
        boxing.getSportCenterSet().add(samsun);
        football.getSportCenterSet().add(izmir);
        football.getSportCenterSet().add(samsun);
        football.getSportCenterSet().add(istanbul);
        tennis.getSportCenterSet().add(izmir);
        tennis.getSportCenterSet().add(istanbul);

        branchRepository.save(basketball);
        branchRepository.save(volleyball);
        branchRepository.save(boxing);
        branchRepository.save(football);
        branchRepository.save(tennis);

        userRepository.save(oguz);
        userRepository.save(burak);
        userRepository.save(onurcan);

    }

}
