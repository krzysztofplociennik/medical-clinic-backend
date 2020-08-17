package com.plociennik.medicalclinicbackend.service;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Optional<Reservation> getReservation(final Long id) {
        return repository.findById(id);
    }

    public Reservation saveReservation(final Reservation reservation) {
        reservation.getDoctor().getReservations().add(reservation);
        reservation.getDoctor().setReservations(reservation.getDoctor().getReservations());
        reservation.getPatient().getReservations().add(reservation);
        reservation.getPatient().setReservations(reservation.getPatient().getReservations());
        return repository.save(reservation);
    }

    public void deleteReservation(final Long id) {
        repository.deleteById(id);
    }
}
