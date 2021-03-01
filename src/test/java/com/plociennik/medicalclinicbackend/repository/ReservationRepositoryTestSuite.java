package com.plociennik.medicalclinicbackend.repository;

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
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryTestSuite {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    private long initialDoctorRepositorySize;
    private long initialPatientRepositorySize;
    private long initialReservationRepositorySize;

    @Before
    public void init() {
        initialDoctorRepositorySize = doctorRepository.count();
        initialPatientRepositorySize = patientRepository.count();
        initialReservationRepositorySize = reservationRepository.count();
        if (initialDoctorRepositorySize == 0 || initialPatientRepositorySize == 0 || initialReservationRepositorySize == 0) {
            putDummyData();
        }
    }

    @After
    public void finalCheck() {
        if (initialDoctorRepositorySize == 0 || initialPatientRepositorySize == 0 || initialReservationRepositorySize == 0) {
            deleteDummyData();
        }
        Assert.assertEquals(initialDoctorRepositorySize, doctorRepository.count());
        Assert.assertEquals(initialPatientRepositorySize, patientRepository.count());
        Assert.assertEquals(initialReservationRepositorySize, reservationRepository.count());
    }

    public void putDummyData() {
        Doctor doctor = new Doctor();
        doctor.setMail("doctorMailExample");
        doctor.setName("doctorNameExample");
        doctorRepository.save(doctor);
        Patient patient = new Patient();
        patient.setMail("patientMailExample");
        patient.setName("patientNameExample");
        patientRepository.save(patient);
        Reservation reservation = new Reservation();
        reservation.setDoctor(doctor);
        reservation.setPatient(patient);
        reservation.setTime("time1");
        reservationRepository.save(reservation);
    }

    public void deleteDummyData() {
        Optional<Doctor> searchedDoctor = doctorRepository.findAll().stream()
                .filter(doctor -> doctor.getName().equals("doctorNameExample"))
                .findAny();
        Optional<Patient> searchedPatient = patientRepository.findAll().stream()
                .filter(patient -> patient.getName().equals("patientNameExample"))
                .findAny();
        Optional<Reservation> searchedReservation = reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getTime().equals("time1"))
                .findAny();
        searchedDoctor.ifPresent(doctor -> doctorRepository.deleteById(doctor.getId()));
        searchedPatient.ifPresent(patient -> patientRepository.deleteById(patient.getId()));
        searchedReservation.ifPresent(reservation -> reservationRepository.deleteById(reservation.getId()));
    }

    @Test
    public void savingAndDeletingReservation() {
        Doctor doctor = doctorRepository.findAll().stream().findFirst().get();
        long initialSizeOfDoctorReservations = doctor.getReservations().size();
        Patient patient = patientRepository.findAll().stream().findFirst().get();
        long initialSizeOfPatientReservations = patient.getReservations().size();
        Reservation reservation = new Reservation();
        reservation.setDoctor(doctor);
        reservation.setPatient(patient);
        String time = LocalDateTime.now().toString();
        reservation.setTime(time);
        reservationRepository.save(reservation);

        long lastAddedReservationId = reservationRepository.findAll().stream()
                .max(Comparator.comparing(Reservation::getId))
                .get()
                .getId();

        Assert.assertEquals(initialReservationRepositorySize + 1, reservationRepository.count());

        Optional<Doctor> searchedDoctor = doctorRepository.findAll().stream()
                .filter(doctor1 -> doctor1.getName().equals(doctor.getName()))
                .findAny();
        Optional<Patient> searchedPatient = patientRepository.findAll().stream()
                .filter(patient1 -> patient1.getName().equals(patient.getName()))
                .findAny();

        Assert.assertEquals(initialSizeOfDoctorReservations + 1, searchedDoctor.get().getReservations().size());
        Assert.assertEquals(initialSizeOfPatientReservations + 1, searchedPatient.get().getReservations().size());

        reservationRepository.deleteById(lastAddedReservationId);

        Optional<Doctor> searchedDoctorAfterDeleting = doctorRepository.findAll().stream()
                .filter(doctor1 -> doctor1.getName().equals(doctor.getName()))
                .findAny();
        Optional<Patient> searchedPatientAfterDeleting = patientRepository.findAll().stream()
                .filter(patient1 -> patient1.getName().equals(patient.getName()))
                .findAny();

        Assert.assertEquals(initialSizeOfDoctorReservations, searchedDoctorAfterDeleting.get().getReservations().size());
        Assert.assertEquals(initialSizeOfPatientReservations, searchedPatientAfterDeleting.get().getReservations().size());
    }

    @Test
    public void editingReservation() {
        Doctor doctor = doctorRepository.findAll().stream().findFirst().get();
        Doctor otherDoctor = doctorRepository.findAll().stream()
                .filter(doctor1 -> !doctor1.getName().equals(doctor.getName()))
                .findAny()
                .get();
        Patient patient = patientRepository.findAll().stream().findFirst().get();
        Reservation reservation = new Reservation();
        reservation.setDoctor(doctor);
        reservation.setPatient(patient);
        reservationRepository.save(reservation);

        Assert.assertEquals(initialReservationRepositorySize + 1, reservationRepository.findAll().size());

        Reservation lastAddedReservation = reservationRepository.findAll().stream()
                .max(Comparator.comparing(Reservation::getId))
                .get();

        lastAddedReservation.setDoctor(otherDoctor);
        reservationRepository.save(lastAddedReservation);

        Assert.assertEquals(initialReservationRepositorySize + 1, reservationRepository.findAll().size());
        Assert.assertEquals(otherDoctor.getName(), reservationRepository.findById(lastAddedReservation.getId()).get().getDoctor().getName());

        reservationRepository.deleteById(lastAddedReservation.getId());
    }
}
