package com.onrcnk.citysports.bootstrap;

import com.onrcnk.citysports.domain.Branch;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.SportsCenter;
import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.repositories.BranchRepository;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.repositories.SportsCenterRepository;
import com.onrcnk.citysports.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class firstDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final FacilityRepository facilityRepository;
    private final SportsCenterRepository sportsCenterRepository;

    public firstDataBootstrap(UserRepository userRepository, BranchRepository branchRepository, FacilityRepository facilityRepository, SportsCenterRepository sportsCenterRepository) {
        this.userRepository = userRepository;
        this.branchRepository = branchRepository;
        this.facilityRepository = facilityRepository;
        this.sportsCenterRepository = sportsCenterRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(userRepository.count()==0) {
            setData();
        }
    }

    public void setData() {

        User oguz = new User();
        User burak = new User();
        User onurcan = new User();

        oguz.setName("Oğuz");
        oguz.setSurname("Direnç Dinç");
        oguz.setPassword("3152");
        oguz.setEmail("dinc.oguz@hotmail.com");
        oguz.setBirthDate("03.01.1981");

        burak.setName("Burak");
        burak.setSurname("Topçu");
        burak.setPassword("1234");
        burak.setEmail("topcu.burak@hotmail.com");
        burak.setBirthDate("14.12.1985");

        onurcan.setName("Onurcan");
        onurcan.setSurname("KURT");
        onurcan.setPassword("9090");
        onurcan.setEmail("kurt.onurcan@hotmail.com");
        onurcan.setBirthDate("10.09.1993");

        SportsCenter izmir = new SportsCenter();
        SportsCenter istanbul = new SportsCenter();
        SportsCenter samsun = new SportsCenter();

        Branch basketball = new Branch();
        Branch volleyball = new Branch();
        Branch tennis = new Branch();
        Branch boxing = new Branch();
        Branch football = new Branch();

        Facility multiFunctionalFacility = new Facility();
        Facility tennisCourt = new Facility();
        Facility tennisCourt2 = new Facility();
        Facility boxingRing = new Facility();
        Facility footballField = new Facility();
        Facility footballField2 = new Facility();
        Facility multiFunctionalFacility2 = new Facility();

        football.setBranchName("Football");
        boxing.setBranchName("Box");
        tennis.setBranchName("Tennis");
        volleyball.setBranchName("Volleyball");
        basketball.setBranchName("Basketball");

        izmir.setSportsCenterName("Izmir Sports Center");
        istanbul.setSportsCenterName("Istanbul Sports Center");
        samsun.setSportsCenterName("Samsun Sports Center");

        footballField.setFacilityName("Istanbul Football Field");
        footballField.setSportsCenter(istanbul);

        boxingRing.setFacilityName("Samsun Boxing Ring");
        boxingRing.setSportsCenter(samsun);

        tennisCourt.setFacilityName("Istanbul Tennis Court");
        tennisCourt.setSportsCenter(istanbul);

        multiFunctionalFacility.setFacilityName("Istanbul Basketball and Volleyball Field");
        multiFunctionalFacility.setSportsCenter(istanbul);

        multiFunctionalFacility2.setFacilityName("Izmir Volleyball and Football Field");
        multiFunctionalFacility2.setSportsCenter(izmir);

        footballField2.setFacilityName("Samsun Football Field");
        footballField2.setSportsCenter(samsun);

        tennisCourt2.setFacilityName("Izmir Tennis Court");
        tennisCourt2.setSportsCenter(izmir);

        sportsCenterRepository.save(izmir);
        sportsCenterRepository.save(istanbul);
        sportsCenterRepository.save(samsun);

        facilityRepository.save(multiFunctionalFacility);
        facilityRepository.save(tennisCourt);
        facilityRepository.save(tennisCourt2);
        facilityRepository.save(boxingRing);
        facilityRepository.save(footballField);
        facilityRepository.save(multiFunctionalFacility2);
        facilityRepository.save(footballField2);

        football.getFacility().add(footballField);
        football.getFacility().add(footballField2);
        boxing.getFacility().add(boxingRing);
        tennis.getFacility().add(tennisCourt);
        tennis.getFacility().add(tennisCourt2);
        basketball.getFacility().add(multiFunctionalFacility);
        volleyball.getFacility().add(multiFunctionalFacility);
        volleyball.getFacility().add(multiFunctionalFacility2);
        football.getFacility().add(multiFunctionalFacility2);

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
