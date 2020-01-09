package com.plociennik.medicalclinicbackend.service;
import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDateTime;
import java.time.Month;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTestSuite {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @Test
    public void savingReservations() {
        //Given
        Reservation reservation = new Reservation();
        reservation.setTime(LocalDateTime.of(2020, Month.APRIL, 21, 19, 40, 00));
        //When
        reservationService.createReservation(reservation);
        int size = reservationService.getAllReservations().size();
        long reservationIndex = reservationService.getAllReservations().get(size-1).getId();
        int result = reservationService.getAllReservations().get(size-1).getTime().getHour();
        //Then
        assertEquals(1, reservationService.getAllReservations().size());
        assertEquals(19, result);
        //Clean up
        reservationService.deleteReservation(reservationIndex);
    }
}
