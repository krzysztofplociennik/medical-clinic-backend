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
        reservationService.saveReservation(reservation);
        int size = reservationService.getAllReservations().size();
        long reservationIndex = reservationService.getAllReservations().get(size-1).getId();
        int result = reservationService.getAllReservations().get(size-1).getTime().getHour();
        //Then
        //assertEquals(1, reservationService.getAllReservations().size());
        System.out.println("The size of reservations repository: " + size);
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
        //assertEquals(3, patientService.getAllPatients().size());
        System.out.println("The size of patients repository: " + size);
        assertEquals("525602556", result);
        //Clean up
        patientService.deletePatient(patientIndex);
    }
    @Test
    public void savingDoctors() {
        //Given
        Doctor doctor = new Doctor();
        doctor.setName("Gregg Norton");
        doctor.setMail("greggnorton@gmail.com");
        doctor.setRating(4.4);
        //When
        doctorService.saveDoctor(doctor);
        int size = doctorService.getAllDoctors().size();
        long doctorIndex = doctorService.getAllDoctors().get(size-1).getId();
        double result = doctorService.getAllDoctors().get(size-1).getRating();
        //Then
        //assertEquals(2, doctorService.getAllDoctors().size());
        System.out.println("The size of doctors repository: " + size);
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
        System.out.println("The size of reservations repository: " + reservationService.getAllReservations().size());
        System.out.println("The size of patients repository: " + patientService.getAllPatients().size());
        System.out.println("The size of doctors repository: " + doctorService.getAllDoctors().size());
        //Clean up
        reservationService.deleteReservation(reservationService.getAllReservations().get(reservationService.getAllReservations().size()-1).getId());
        patientService.deletePatient(patientService.getAllPatients().get(patientService.getAllPatients().size()-1).getId());
        doctorService.deleteDoctor(doctorService.getAllDoctors().get(doctorService.getAllDoctors().size()-1).getId());
    }
    @Test
    public void findingRecords() {
        System.out.println(doctorService.getDoctorFromName("Jessica Hugh").getName());
    }
    @Test
    public void init() {
        Reservation reservation1 = new Reservation();
        reservation1.setTime(LocalDateTime.of(2020, Month.APRIL, 21, 19, 40, 00));
        reservation1.setDoctor(doctorService.getDoctorFromName("Jessica Hugh"));
        reservation1.setPatient(patientService.getPatientFromName("Sandra Ham"));
        reservationService.saveReservation(reservation1);
        Reservation reservation2 = new Reservation();
        reservation2.setTime(LocalDateTime.of(2020, Month.APRIL, 22, 9, 00, 00));
        reservation2.setDoctor(doctorService.getDoctorFromName("Jessica Hugh"));
        reservation2.setPatient(patientService.getPatientFromName("Sam Toronto"));
        reservationService.saveReservation(reservation2);
        Reservation reservation3 = new Reservation();
        reservation3.setTime(LocalDateTime.of(2020, Month.APRIL, 22, 10, 00, 00));
        reservation3.setDoctor(doctorService.getDoctorFromName("John Doe"));
        reservation3.setPatient(patientService.getPatientFromName("Sandra Ham"));
        reservationService.saveReservation(reservation3);
    }
}
