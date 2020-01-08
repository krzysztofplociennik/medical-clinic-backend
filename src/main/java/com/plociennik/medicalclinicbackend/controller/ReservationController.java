package com.plociennik.medicalclinicbackend.controller;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.domain.ReservationDto;
import com.plociennik.medicalclinicbackend.mapper.ReservationsMapper;
import com.plociennik.medicalclinicbackend.repository.ReservationRepository;
import com.plociennik.medicalclinicbackend.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private DatabaseService service;
    @Autowired
    private ReservationsMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReservations")
    public List<ReservationDto> getAllPatientReservations(Long patientId) {
        return mapper.mapToReservationDtoList(service.getAllReservations());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservation")
    public Reservation getReservation(Long reservationId) {
        return new Reservation();
    }

    @RequestMapping(method = RequestMethod.POST, value = "makeReservation")
    public Reservation makeReservation() {
        return new Reservation();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeReservation")
    public Reservation changeReservation(Long reservationId) {
        return new Reservation();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "cancelReservation")
    public String cancelReservation(Long reservationId) {
        return "Reservation has been canceled!";
    }

}
