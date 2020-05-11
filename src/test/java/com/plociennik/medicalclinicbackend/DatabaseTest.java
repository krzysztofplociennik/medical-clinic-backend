package com.plociennik.medicalclinicbackend;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.service.DoctorService;
import com.plociennik.medicalclinicbackend.service.PatientService;
import com.plociennik.medicalclinicbackend.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @Test
    public void whatever() {
        //Reservation reservation = new Reservation();
        //reservationRepository.save(reservation);
        reservationService.saveReservation(new Reservation(221L,
                LocalDateTime.of(2020, 4, 26, 17, 0),
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(221L,
                LocalDateTime.of(2020, 4, 26, 17, 0),
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(221L,
                LocalDateTime.of(2020, 4, 26, 17, 0),
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(221L,
                LocalDateTime.of(2020, 4, 26, 17, 0),
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(221L,
                LocalDateTime.of(2020, 4, 26, 17, 0),
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(221L,
                LocalDateTime.of(2020, 4, 26, 17, 0),
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(221L,
                LocalDateTime.of(2020, 4, 26, 17, 0),
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        System.out.println(reservationService.getAllReservations().size());
    }
}
