package com.plociennik.medicalclinicbackend.service;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {
    //@Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(final Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation makeReservation(final Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(final Long id) {
       reservationRepository.deleteById(id);
    }
}
