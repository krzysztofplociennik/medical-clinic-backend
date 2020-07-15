package com.plociennik.medicalclinicbackend.service;
import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        reservation.setTime("2016-03-04 11:30");
        //When
        reservationService.saveReservation(reservation);
        int size = reservationService.getAllReservations().size();
        long reservationIndex = reservationService.getAllReservations().get(size-1).getId();
        //Then
        System.out.println("The size of reservations repository: " + size);
        //Clean up
        reservationService.deleteReservation(reservationIndex);
    }

    @Test
    public void savingPatients() {
        Patient patient = new Patient();
        patient.setName("Antonio Cumia");
        patient.setMail("antoniocumia@gmail.com");
        patient.setPhoneNumber("525602556");
        patientService.savePatient(patient);
    }

    @Test
    public void savingDoctors() {
        Doctor doctor = new Doctor();
        doctor.setName("X");
        doctor.setMail("x@gmail.com");
        doctorService.saveDoctor(doctor);
    }

    @Test
    public void findingRecords() {
        System.out.println(doctorService.getDoctorFromName("Jessica Hugh").getName());
    }

    @Test
    public void createPatient() {
        Patient patient = new Patient();
        patient.setName("Jamilyn Harrison");
        patient.setPhoneNumber("142122678");
        patientService.savePatient(patient);
    }

    @Test
    public void createDoctor() {
        Doctor doctor = new Doctor();
        doctor.setName("Jim Keyb");
        doctorService.saveDoctor(doctor);
    }
}
