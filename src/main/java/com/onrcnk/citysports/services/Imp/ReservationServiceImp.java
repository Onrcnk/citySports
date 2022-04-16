package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.commands.DayAndTimeListCommand;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.mappers.ReservationMapper;
import com.onrcnk.citysports.repositories.ReservationRepository;
import com.onrcnk.citysports.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
@Service
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    public static int RESERVATION_START_TIME = 8;
    public static int RESERVATION_END_TIME = 18;

    public ReservationServiceImp(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public Set<LocalDateTime> getDayAndTimeSet(){
        LocalDateTime date = LocalDateTime.now();
        Set<LocalDateTime> dates = new LinkedHashSet<>();

        for(int i=0; i < 7; i++){
            for(int j=RESERVATION_START_TIME; j <= RESERVATION_END_TIME; j++){
                if(date.getHour() < RESERVATION_END_TIME) {
                    dates.add(date.plusDays(i).withHour(j).truncatedTo(ChronoUnit.HOURS));

                }
            }
        }
        return dates;
    }

    @Override
    public Set<DayAndTimeListCommand> getReservation(){

        Set<ReservationCommand> reservationCommands = new LinkedHashSet<>();
        List<Reservation> reservations = reservationRepository.findAll();
        Set<LocalDateTime> dayAndTimeSet = getDayAndTimeSet();

        Set<DayAndTimeListCommand> dayAndTimeListCommands = new LinkedHashSet<>();

        for (LocalDateTime localDateTime : dayAndTimeSet){
            DayAndTimeListCommand dayAndTimeListCommand = new DayAndTimeListCommand();
            dayAndTimeListCommand.setDayAndTime(localDateTime);
            dayAndTimeListCommand.setStatus("FREE");
            dayAndTimeListCommand.setDayName(localDateTime.getDayOfWeek().toString());
            dayAndTimeListCommands.add(dayAndTimeListCommand);
        }

        for(Reservation reservation : reservations){
            for(DayAndTimeListCommand dayAndTimeListCommand : dayAndTimeListCommands){
                if(dayAndTimeListCommand.getDayAndTime().equals(reservation.getDateAndTime().truncatedTo(ChronoUnit.HOURS))){
                    dayAndTimeListCommand.setStatus("RESERVED");
                }
            }
        }
        return dayAndTimeListCommands;
    }
}
