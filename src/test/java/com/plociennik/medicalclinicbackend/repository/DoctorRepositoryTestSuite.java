package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Rating;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorRepositoryTestSuite {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RatingRepository ratingRepository;

    @Test
    public void findingSize() {
        long size = doctorRepository.count();
        System.out.println("\nHere's the total number of doctors: " + size);
    }

    @Test
    public void savingDoctor() {
        long initialSize = doctorRepository.count();

        Doctor doctor = new Doctor();
        Rating rating = new Rating();
        doctor.setRating("");
        doctor.getRatings().add(rating);
        doctorRepository.save(doctor);
        ratingRepository.save(rating);
        long sizeAfterSaving = doctorRepository.count();

        Assert.assertEquals(initialSize + 1, sizeAfterSaving);
        //Clean up
        doctorRepository.delete(doctor);
    }

    @Test
    public void deletingDoctor() {
        long initialSize = doctorRepository.count();

        Doctor doctor = new Doctor();
        doctorRepository.save(doctor);
        Long id = doctorRepository.findAll().get((int) initialSize).getId();

        long sizeAfterSaving = doctorRepository.count();

        Assert.assertEquals(initialSize + 1, sizeAfterSaving);

        doctorRepository.deleteById(id);
        long sizeAfterDeleting = doctorRepository.count();

        Assert.assertEquals(initialSize, sizeAfterDeleting);
    }

    @Test
    public void printingVariousData() {

        for (Doctor doctor : doctorRepository.findAll()) {
            System.out.println(doctor.getRating());
        }
    }

    @Test
    public void editData() {
    }

    @Test
    public void populate() {
        Doctor patient1 = new Doctor(500L, "1", "1@g.com", "111",
                new LinkedHashSet<>(), new ArrayList<>());
        Doctor patient2 = new Doctor(500L, "2", "2@g.com", "222",
                new LinkedHashSet<>(), new ArrayList<>());
        Doctor patient3 = new Doctor(500L, "3", "3@g.com", "333",
                new LinkedHashSet<>(), new ArrayList<>());
        Doctor patient4 = new Doctor(500L, "4", "4@g.com", "444",
                new LinkedHashSet<>(), new ArrayList<>());
        Doctor patient5 = new Doctor(500L, "5", "5@g.com", "555",
                new LinkedHashSet<>(), new ArrayList<>());

        doctorRepository.saveAll(Arrays.asList(patient1, patient2, patient3, patient4, patient5));
    }
}
