package com.plociennik.medicalclinicbackend;

import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.service.DoctorService;
import com.plociennik.medicalclinicbackend.service.PatientService;
import com.plociennik.medicalclinicbackend.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void addingSomeReservations() {
        reservationService.saveReservation(new Reservation(1L,
                "2016-03-04 11:30",
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(1L,
                "2016-03-04 11:30",
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(1L,
                "2016-03-04 11:30",
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(1L,
                "2016-03-04 11:30",
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(1L,
                "2016-03-04 11:30",
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(1L,
                "2016-03-04 11:30",
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        reservationService.saveReservation(new Reservation(1L,
                "2016-03-04 11:30",
                patientService.getPatientFromName("Sandra Ham"),
                doctorService.getDoctorFromName("John Doe")));
        System.out.println("The size of the reservations base: " + reservationService.getAllReservations().size());
    }

    @Test
    public void deleteSpecificReservation() {
        System.out.println("The size of the reservations base: " + reservationService.getAllReservations().size());
        reservationService.deleteReservation(171L);
        System.out.println("The size of the reservations base: " + reservationService.getAllReservations().size());
    }

    @Test
    public void checkNumberOfAllReservations() {
        System.out.println("The size of the reservations base: " + reservationService.getAllReservations().size());
        System.out.println("And these are all the reservations' id: ");
        for (Reservation instance : reservationService.getAllReservations()) {
            System.out.print(instance.getId() + " ");
        }
    }

    @Test
    public void checkingPatientDoctorListsContents() {
        for (Patient patient : patientService.getAllPatients()) {
            System.out.println("The size of patient's [" + patient.getName() + "] reservations list: " + patient.getReservations().size());
            System.out.println("These are all the ids of the patient's reservations: ");
            for (Reservation reservation : patient.getReservations()) {
                System.out.print(reservation.getId() + " ");
            }
        }

        for (Doctor doctor : doctorService.getAllDoctors()) {
            System.out.println("The size of doctor's [" + doctor.getName() + "] reservations list: " + doctor.getReservations().size());
            System.out.println("These are all the ids of the doctor's reservations: ");
            for (Reservation reservation : doctor.getReservations()) {
                System.out.print(reservation.getId() + " ");
            }
        }
    }
}
