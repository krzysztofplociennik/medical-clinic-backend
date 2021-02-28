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

import java.util.Optional;

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

}
