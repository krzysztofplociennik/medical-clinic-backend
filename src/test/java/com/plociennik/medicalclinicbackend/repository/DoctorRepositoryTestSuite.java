package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Doctor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
=======
import java.util.Optional;
>>>>>>> iss007-testing

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorRepositoryTestSuite {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RatingRepository ratingRepository;

    private long initialDoctorRepositorySize;
    private long initialPatientRepositorySize;
    private long initialRatingRepositorySize;

    @Before
    public void init() {
        initialDoctorRepositorySize = doctorRepository.count();
        initialPatientRepositorySize = patientRepository.count();
        initialRatingRepositorySize = ratingRepository.count();
    }

    @After
    public void finalCheck() {
        Assert.assertEquals(initialDoctorRepositorySize, doctorRepository.count());
        Assert.assertEquals(initialPatientRepositorySize, patientRepository.count());
        Assert.assertEquals(initialRatingRepositorySize, ratingRepository.count());
    }


    @Test
    public void savingAndDeletingDoctor() {
        Doctor doctor = new Doctor();
        doctor.setName("Confidential");
        doctor.setMail("Confidential");
        doctorRepository.save(doctor);

        Assert.assertEquals(initialDoctorRepositorySize + 1, doctorRepository.count());

        Optional<Doctor> searchedDoctor = doctorRepository.findAll().stream()
                .filter(doctor1 -> doctor1.getName().equals("Confidential"))
                .findAny();

        Assert.assertNotNull(searchedDoctor);

        doctorRepository.deleteById(searchedDoctor.get().getId());
    }

    @Test
    public void editingDoctor() {
        Doctor doctor = new Doctor();
        doctor.setName("Confidential");
        doctor.setMail("Confidential");
        doctorRepository.save(doctor);

        Assert.assertEquals(initialDoctorRepositorySize + 1, doctorRepository.count());

        Optional<Doctor> searchedDoctor = doctorRepository.findAll().stream()
                .filter(doctor1 -> doctor1.getName().equals("Confidential"))
                .findAny();

        Assert.assertNotNull(searchedDoctor);

        searchedDoctor.get().setName("Confidential [edited]");
        searchedDoctor.get().setMail("Confidential [also edited]");
        doctorRepository.save(searchedDoctor.get());

        Optional<Doctor> searchedEditedDoctor = doctorRepository.findAll().stream()
                .filter(doctor1 -> doctor1.getName().equals("Confidential [edited]"))
                .findAny();

        Assert.assertNotNull(searchedEditedDoctor);
        Assert.assertEquals("Confidential [also edited]", searchedEditedDoctor.get().getMail());
        Assert.assertEquals(initialDoctorRepositorySize + 1, doctorRepository.count());

        doctorRepository.deleteById(searchedDoctor.get().getId());
    }

<<<<<<< HEAD
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
=======
>>>>>>> iss007-testing
}
