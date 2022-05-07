package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.commands.DayCommand;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.commands.TimeCommand;
import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.domain.ReservationStatus;
import com.onrcnk.citysports.domain.User;
import com.onrcnk.citysports.repositories.CartRepository;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.repositories.ReservationRepository;
import com.onrcnk.citysports.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.onrcnk.citysports.domain.ReservationStatus.INTHECART;
import static com.onrcnk.citysports.domain.ReservationStatus.RESERVED;

@Slf4j
@Service
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CartRepository cartRepository;
    private final FacilityRepository facilityRepository;
    public static int RESERVATION_START_TIME = 8;
    public static int RESERVATION_END_TIME = 18;

    public ReservationServiceImp(ReservationRepository reservationRepository, CartRepository cartRepository, FacilityRepository facilityRepository) {
        this.reservationRepository = reservationRepository;
        this.cartRepository = cartRepository;
        this.facilityRepository = facilityRepository;
    }

    public Set<DayCommand> getDayOfWeek(){
        LocalDateTime date = LocalDateTime.now();
        Set<DayCommand> dayCommandSet= new LinkedHashSet<>();


        for(int i=0; i < 7; i++){
            DayCommand dayCommand = new DayCommand();
            Set<TimeCommand> timeCommandSet = new LinkedHashSet<>();
            String dayName = date.plusDays(i).getDayOfWeek().toString();
            dayCommand.setDayName(dayName);

            for(int j=RESERVATION_START_TIME; j <= RESERVATION_END_TIME; j++) {
                TimeCommand timeCommand = new TimeCommand();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dayAndTime = date.plusDays(i).withHour(j).truncatedTo(ChronoUnit.HOURS);
                String dayAndTimeFormat = dayAndTime.format(formatter);
                timeCommand.setTime(dayAndTimeFormat);
                if(date.isAfter(dayAndTime)){
                    timeCommand.setStatus(ReservationStatus.UNAVAILABLE);
                }else{
                    timeCommand.setStatus(ReservationStatus.RESERVE);
                }
                timeCommandSet.add(timeCommand);
                dayCommand.setTimeCommand(timeCommandSet);
                dayCommandSet.add(dayCommand);
            }
        }

        return dayCommandSet;
    }

    @Override
    public Set<ReservationCommand> creatReservationCommandList(String facilityId){
        Set<ReservationCommand> reservationCommands = new LinkedHashSet<>();
        Set<DayCommand> dayCommandSet = getDayOfWeek();

        for (DayCommand dayCommand : dayCommandSet){

            ReservationCommand reservationCommand = new ReservationCommand();
            reservationCommand.setDayCommand(dayCommand);
            reservationCommands.add(reservationCommand);
        }

        return reservationCommands;
    }

    @Override
    public Reservation creatReservationObject(@NotNull TimeCommand timeCommandReference, String facilityId, User user){

        Reservation reservation = new Reservation();
        reservation.setFacilityId(facilityId);
        reservation.setDateAndTime(timeCommandReference.time);
        reservation.setStatus(INTHECART);
        reservation.setUser(user);
        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public Set<ReservationCommand> getReservation(String facilityId){
        Set<Reservation> reservations = reservationRepository.findByFacilityId(facilityId);
        Set<ReservationCommand> reservationCommands = creatReservationCommandList(facilityId);

        for(Reservation reservation : reservations) {
            for (ReservationCommand reservationCommand : reservationCommands) {
                for (TimeCommand timeCommand : reservationCommand.getDayCommand().timeCommand) {
                    if (timeCommand.time.equals(reservation.getDateAndTime())) {
                        timeCommand.setStatus(RESERVED);
                    }
                }
            }
        }
        return reservationCommands;
    }

    @Override
    public Set<ReservationCommand> setReservationToCart(TimeCommand timeCommandReference,String facilityId,
                                                        User user) {

        creatReservationObject(timeCommandReference, facilityId, user);

        Set<Reservation> reservations = reservationRepository.findByFacilityId(facilityId);
        Set<ReservationCommand> reservationCommands = creatReservationCommandList(facilityId);

        for(Reservation reservationObj : reservations) {
            for (ReservationCommand reservationCommand : reservationCommands) {
                for (TimeCommand timeCommand : reservationCommand.getDayCommand().timeCommand) {
                    if (timeCommand.time.equals(reservationObj.getDateAndTime())) {
                        timeCommand.setStatus(INTHECART);
                    }
                }
            }
        }
        return reservationCommands;
    }

}
