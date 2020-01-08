package com.plociennik.medicalclinicbackend.repository;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    @Override
    List<Reservation> findAll();
}
