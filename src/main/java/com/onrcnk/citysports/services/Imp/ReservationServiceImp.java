package com.onrcnk.citysports.services.Imp;

import com.onrcnk.citysports.commands.DayCommandList;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.commands.TimeCommandList;
import com.onrcnk.citysports.domain.Reservation;
import com.onrcnk.citysports.mappers.ReservationMapper;
import com.onrcnk.citysports.repositories.ReservationRepository;
import com.onrcnk.citysports.services.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public Map<String, ArrayList<String>> getDayOfWeek(){
        LocalDateTime date = LocalDateTime.now();
        Map<String, ArrayList<String>> dates = new HashMap<String, ArrayList<String>>();

        for(int i=0; i < 7; i++){
            String dayName = date.plusDays(i).getDayOfWeek().toString();
            dates.put(dayName, new ArrayList<String>());
            for(int j=RESERVATION_START_TIME; j <= RESERVATION_END_TIME; j++) {
                String dayAndTime = date.plusDays(i).withHour(j).truncatedTo(ChronoUnit.HOURS).toString();
                dates.get(dayName).add(dayAndTime);
            }
        }

        return dates;
    }

    public List<String> getHourOfDay(){
        LocalTime time = LocalTime.now();
        List<String> timeList = new LinkedList<>();

        for(int j=RESERVATION_START_TIME; j <= RESERVATION_END_TIME; j++) {
            timeList.add(time.withHour(j).truncatedTo(ChronoUnit.HOURS).toString());
        }

        return timeList;
    }

    @Override
    public Set<ReservationCommand> getReservation(){

        Set<ReservationCommand> reservationCommands = new LinkedHashSet<>();
        List<Reservation> reservations = reservationRepository.findAll();
        Map<String, ArrayList<String>> dayOfWeeks = getDayOfWeek();
        List<String> hourOfDay = getHourOfDay();

        for (String day : dayOfWeeks.keySet()){

            for(String time : dayOfWeeks.get(day)) {
                DayCommandList dayCommandList = new DayCommandList();
                TimeCommandList timeCommandList = new TimeCommandList();
                ReservationCommand reservationCommand = new ReservationCommand();
                dayCommandList.setDayName(day);
                dayCommandList.setStatus("FREE");
                timeCommandList.setTime(time);
                dayCommandList.setTime(timeCommandList);

                reservationCommand.setDayCommandList(dayCommandList);
                reservationCommands.add(reservationCommand);
            }
        }

        for(Reservation reservation : reservations){
            for(ReservationCommand reservationCommand : reservationCommands){
                if(reservationCommand.dayCommandList.getTime().time.equals(reservation.getDateAndTime().truncatedTo(ChronoUnit.HOURS).toString())){
                    reservationCommand.dayCommandList.setStatus("RESERVED");
                }
            }
        }



        return reservationCommands;
    }
}
