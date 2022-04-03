package com.onrcnk.citysports.bootstrap;

import com.onrcnk.citysports.domain.Branch;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.SportCenter;
import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.repositories.BranchRepository;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import com.onrcnk.citysports.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class firstDataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final BranchRepository branchRepository;
    private final FacilityRepository facilityRepository;
    private final SportCenterRepository sportCenterRepository;

    public firstDataBootstrap(UserRepository userRepository, BranchRepository branchRepository, FacilityRepository facilityRepository, SportCenterRepository sportsCenterRepository) {
        this.userRepository = userRepository;
        this.branchRepository = branchRepository;
        this.facilityRepository = facilityRepository;
        this.sportCenterRepository = sportsCenterRepository;
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

        tennisCourt3.setFacilityName("Izmır Tennis Court - 2");
        tennisCourt3.setSportsCenter(izmir);

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
