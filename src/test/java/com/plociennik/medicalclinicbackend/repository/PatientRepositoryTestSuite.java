package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Patient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTestSuite {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void findingSize() {
        long size = patientRepository.count();
        System.out.println("\nHere's the total number of patients: " + size);
    }

    @Test
    public void savingPatient() {
        long initialSize = patientRepository.count();

        Patient patient = new Patient();
        patientRepository.save(patient);
        long sizeAfterSaving = patientRepository.count();

        Assert.assertEquals(initialSize + 1, sizeAfterSaving);
        //Clean up
        patientRepository.delete(patient);
    }

    @Test
    public void deletingPatient() {
        long initialSize = patientRepository.count();

        Patient patient = new Patient();
        patientRepository.save(patient);
        Long id = patientRepository.findAll().get((int) initialSize).getId();

        long sizeAfterSaving = patientRepository.count();

        Assert.assertEquals(initialSize + 1, sizeAfterSaving);

        patientRepository.deleteById(id);
        long sizeAfterDeleting = patientRepository.count();

        Assert.assertEquals(initialSize, sizeAfterDeleting);
    }

    @Test
    public void initData() {
    }

    @Test
    public void deleteSpecificId() {
        Optional<Patient> patient = patientRepository.findById(550L);
        patientRepository.delete(patient.get());
    }

    @Test
    public void editData() {
        Optional<Patient> patient = patientRepository.findById(511L);
        patient.get().setName("x");
        patient.get().setPhoneNumber("x");
        patientRepository.save(patient.get());
    }

    @Test
    public void showSpecificData() {
        System.out.println(patientRepository.findById(549L).get().getRatings().size());
        System.out.println(patientRepository.findById(549L).get().getReservations().size());
    }

}