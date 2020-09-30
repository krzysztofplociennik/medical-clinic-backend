package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Patient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashSet;
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
        Optional<Patient> patient = patientRepository.findById(497L);
        patient.get().setPassword("mafe");
        patientRepository.save(patient.get());
    }

    @Test
    public void showSpecificData() {
        System.out.println(patientRepository.findById(497L).get().getUsername());
    }

    @Test
    public void populate() {
        Patient patient1 = new Patient(500L, "1", "1@g.com", "111", "1",
                "1", new LinkedHashSet<>(), new ArrayList<>());
        Patient patient2 = new Patient(500L, "2", "2@g.com", "222", "2",
                "2", new LinkedHashSet<>(), new ArrayList<>());
        Patient patient3 = new Patient(500L, "3", "3@g.com", "333", "3",
                "3", new LinkedHashSet<>(), new ArrayList<>());
        Patient patient4 = new Patient(500L, "4", "4@g.com", "444", "4",
                "4", new LinkedHashSet<>(), new ArrayList<>());
        Patient patient5 = new Patient(500L, "5", "5@g.com", "555", "5",
                "5", new LinkedHashSet<>(), new ArrayList<>());

//        patientRepository.save(patient1);

//        patientRepository.saveAll(Arrays.asList(patient2, patient3, patient4, patient5));
    }

}