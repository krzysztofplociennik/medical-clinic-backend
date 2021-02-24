package com.plociennik.medicalclinicbackend.service;

import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceTestSuite {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    long initialReservationRepositorySize;

    @Before
    public void init() {
        initialReservationRepositorySize = reservationService.getAllReservations().size();
    }

    @After
    public void finalCheck() {
        Assert.assertEquals(initialReservationRepositorySize, reservationService.getAllReservations().size());
    }

    @Test
    public void saveAndDeleteReservation() {
        Doctor doctor = doctorService.getAllDoctors().stream().findFirst().get();
        long initialSizeOfReservationsInDoctor = doctor.getReservations().size();
        Patient patient = patientService.getAllPatients().stream().findFirst().get();
        long initialSizeOfReservationsInPatient = patient.getReservations().size();
        Reservation reservation = new Reservation();
        reservation.setDoctor(doctor);
        reservation.setPatient(patient);

        reservationService.saveReservation(reservation);

        List<Reservation> allReservations = reservationService.getAllReservations();
        Reservation lastAddedReservation = allReservations.get(allReservations.size() - 1);

        Assert.assertNull(lastAddedReservation.getTime());
        Assert.assertEquals(initialReservationRepositorySize + 1, reservationService.getAllReservations().size());
        Assert.assertEquals(initialSizeOfReservationsInDoctor + 1, doctorService.getAllDoctors().stream().findFirst().get().getReservations().size());
        Assert.assertEquals(initialSizeOfReservationsInPatient + 1, patientService.getAllPatients().stream().findFirst().get().getReservations().size());

        reservationService.deleteReservation(lastAddedReservation.getId());

        Assert.assertEquals(initialSizeOfReservationsInDoctor, doctorService.getAllDoctors().stream().findFirst().get().getReservations().size());
        Assert.assertEquals(initialSizeOfReservationsInPatient, patientService.getAllPatients().stream().findFirst().get().getReservations().size());
    }


}
