package com.plociennik.medicalclinicbackend.service;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatabaseService {

    //@Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
