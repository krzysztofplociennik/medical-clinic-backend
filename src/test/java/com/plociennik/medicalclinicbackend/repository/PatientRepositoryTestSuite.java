package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Patient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientRepositoryTestSuite {
    @Autowired
    private PatientRepository patientRepository;

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
}