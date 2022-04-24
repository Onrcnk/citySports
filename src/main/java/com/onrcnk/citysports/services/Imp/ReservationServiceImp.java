package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.commands.DayCommand;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.commands.TimeCommand;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.repositories.FacilityRepository;
import com.onrcnk.citysports.repositories.ReservationRepository;
import com.onrcnk.citysports.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final FacilityRepository facilityRepository;
    public static int RESERVATION_START_TIME = 8;
    public static int RESERVATION_END_TIME = 18;

    public ReservationServiceImp(ReservationRepository reservationRepository, FacilityRepository facilityRepository) {
        this.reservationRepository = reservationRepository;
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
    public Set<ReservationCommand> getReservation(String facilityId){

        Set<ReservationCommand> reservationCommands = new LinkedHashSet<>();
        Optional<Facility> facility = facilityRepository.findById(facilityId);
        Set<Reservation> reservations = facility.get().getReservationSet();
        Set<DayCommand> dayCommandSet = getDayOfWeek();

        for (DayCommand dayCommand : dayCommandSet){

            ReservationCommand reservationCommand = new ReservationCommand();
            reservationCommand.setDayCommand(dayCommand);
            reservationCommands.add(reservationCommand);

        }

        for(Reservation reservation : reservations) {
            for (ReservationCommand reservationCommand : reservationCommands) {
                for (TimeCommand timeCommand : reservationCommand.getDayCommand().timeCommand) {
                    if (timeCommand.time.equals(reservation.getDateAndTime().truncatedTo(ChronoUnit.HOURS))) {
                        timeCommand.setStatus(true);
                    }
                }
            }
        }
        return reservationCommands;
    }
}
