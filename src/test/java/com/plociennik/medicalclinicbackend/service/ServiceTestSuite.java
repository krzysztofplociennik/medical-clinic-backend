package com.plociennik.medicalclinicbackend.service;
import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.repository.DoctorRepository;
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
        reservationService.saveReservation(reservation);
        int size = reservationService.getAllReservations().size();
        long reservationIndex = reservationService.getAllReservations().get(size-1).getId();
        int result = reservationService.getAllReservations().get(size-1).getTime().getHour();
        //Then
        assertEquals(1, reservationService.getAllReservations().size());
        assertEquals(19, result);
        //Clean up
        reservationService.deleteReservation(reservationIndex);
    }
    @Test
    public void savingPatients() {
        //Given
        Patient patient = new Patient();
        patient.setName("Antonio Cumia");
        patient.setMail("antoniocumia@gmail.com");
        patient.setPhoneNumber("525602556");
        //When
        patientService.savePatient(patient);
        int size = patientService.getAllPatients().size();
        long patientIndex = patientService.getAllPatients().get(size-1).getId();
        String result = patientService.getAllPatients().get(size-1).getPhoneNumber();
        //Then
        assertEquals(3, patientService.getAllPatients().size());
        assertEquals("525602556", result);
        //Clean up
        patientService.deletePatient(patientIndex);
    }
    @Test
    public void savingDoctors() {
        //Given
        Doctor doctor = new Doctor();
        doctor.setName("Gregg Norton");
        doctor.setMail("gressnorton@gmail.com");
        doctor.setRating(4.4);
        //When
        doctorService.saveDoctor(doctor);
        int size = doctorService.getAllDoctors().size();
        long doctorIndex = doctorService.getAllDoctors().get(size-1).getId();
        double result = doctorService.getAllDoctors().get(size-1).getRating();
        //Then
        assertEquals(2, doctorService.getAllDoctors().size());
        assertEquals(4.4, result, 0.1);
        //Clean up
        doctorService.deleteDoctor(doctorIndex);
    }
    @Test
    public void whatever() {
        //Given
        Patient patient = new Patient();
        patient.setName("Ryan Jackman");
        patient.setPhoneNumber("213354890");
        patientService.savePatient(patient);
        Doctor doctor = new Doctor();
        doctor.setName("Paul Burr");
        doctor.setRating(4.3);
        doctorService.saveDoctor(doctor);
        //When
        Reservation reservation = new Reservation();
        reservation.setTime(LocalDateTime.of(2020, Month.JANUARY, 22, 10, 00));
        reservation.setPatient(patient);
        reservation.setDoctor(doctor);
        reservationService.saveReservation(reservation);
        //Then
        //Clean up
        reservationService.deleteReservation(reservationService.getAllReservations().get(reservationService.getAllReservations().size()-1).getId());
    }
    @Test
    public void findingRecords() {
        System.out.println(doctorService.getDoctorFromName("Jessica Hugh").getName());
    }
}
