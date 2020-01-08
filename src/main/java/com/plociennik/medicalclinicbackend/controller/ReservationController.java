package com.plociennik.medicalclinicbackend.controller;
import com.plociennik.medicalclinicbackend.domain.ReservationDto;
import com.plociennik.medicalclinicbackend.exceptions.ReservationNotFound;
import com.plociennik.medicalclinicbackend.mapper.ReservationsMapper;
import com.plociennik.medicalclinicbackend.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private DatabaseService service;
    @Autowired
    private ReservationsMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReservations")
    public List<ReservationDto> getAllPatientReservations() {
        return mapper.mapToReservationDtoList(service.getAllReservations());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservation")
    public ReservationDto getReservation(@RequestParam Long reservationId) throws ReservationNotFound {
        return mapper.mapToReservationDto(service.getReservation(reservationId).orElseThrow(ReservationNotFound::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "makeReservation")
    public void makeReservation(@RequestBody ReservationDto reservationDto) {
        service.makeReservation(mapper.mapToReservation(reservationDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeReservation")
    public ReservationDto changeReservation(@RequestBody ReservationDto reservationDto) {
        return mapper.mapToReservationDto(service.makeReservation(mapper.mapToReservation(reservationDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "cancelReservation")
    public void cancelReservation(@RequestParam Long reservationId) {
        service.cancelReservation(reservationId);
    }

}
