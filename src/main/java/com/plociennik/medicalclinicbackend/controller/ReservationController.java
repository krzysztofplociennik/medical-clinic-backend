package com.plociennik.medicalclinicbackend.controller;
import com.plociennik.medicalclinicbackend.domain.ReservationDto;
import com.plociennik.medicalclinicbackend.exceptions.ReservationNotFound;
import com.plociennik.medicalclinicbackend.mapper.ReservationMapper;
import com.plociennik.medicalclinicbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rsrv")
public class ReservationController {
    @Autowired
    private ReservationService service;
    @Autowired
    private ReservationMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getReservations")
    public List<ReservationDto> getAllPatientReservations() {
        return mapper.mapToReservationDtoList(service.getAllReservations());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservation")
    public ReservationDto getReservation(@RequestParam Long reservationId) throws ReservationNotFound {
        return mapper.mapToReservationDto(service.getReservation(reservationId).orElseThrow(ReservationNotFound::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReservation")
    public void createReservation(@RequestBody ReservationDto reservationDto) {
        service.saveReservation(mapper.mapToReservation(reservationDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateReservation")
    public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto) {
        return mapper.mapToReservationDto(service.saveReservation(mapper.mapToReservation(reservationDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReservation")
    public void deleteReservation(@RequestParam Long reservationId) {
        service.deleteReservation(reservationId);
    }
}
