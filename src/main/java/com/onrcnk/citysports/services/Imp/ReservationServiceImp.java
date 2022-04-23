package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.commands.DayCommand;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.commands.TimeCommand;
import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.repositories.ReservationRepository;
import com.onrcnk.citysports.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
@Service
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepository reservationRepository;
    public static int RESERVATION_START_TIME = 8;
    public static int RESERVATION_END_TIME = 18;

    public ReservationServiceImp(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
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
                LocalDateTime dayAndTime = date.plusDays(i).withHour(j).truncatedTo(ChronoUnit.HOURS);
                timeCommand.setTime(dayAndTime);
                timeCommand.setStatus(date.isAfter(timeCommand.getTime()));
                timeCommandSet.add(timeCommand);
                dayCommand.setTimeCommand(timeCommandSet);
                dayCommandSet.add(dayCommand);
            }
        }

        return dayCommandSet;
    }

    @Override
    public Set<ReservationCommand> getReservation(){

        Set<ReservationCommand> reservationCommands = new LinkedHashSet<>();
        List<Reservation> reservations = reservationRepository.findAll();
        Set<DayCommand> dayCommandSet = getDayOfWeek();

        for (DayCommand dayCommand : dayCommandSet){

            ReservationCommand reservationCommand = new ReservationCommand();
            reservationCommand.setDayCommand(dayCommand);
            reservationCommands.add(reservationCommand);

        }

        for(Reservation reservation : reservations){
            for(ReservationCommand reservationCommand : reservationCommands){
                for (TimeCommand timeCommand : reservationCommand.getDayCommand().timeCommand) {
                    if(timeCommand.time.equals(reservation.getDateAndTime().truncatedTo(ChronoUnit.HOURS))){
                        timeCommand.setStatus(true);
                    }

                }

            }
        }

        return reservationCommands;
    }
}
