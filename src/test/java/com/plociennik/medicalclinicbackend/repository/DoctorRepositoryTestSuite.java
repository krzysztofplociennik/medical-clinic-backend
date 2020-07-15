package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Doctor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorRepositoryTestSuite {
    @Autowired
    private DoctorRepository repository;

    @Test
    public void findingSize() {
        System.out.println(repository.findAll().size());
    }

    @Test
    public void findingSpecificDoctor() {
        Doctor doctor = repository.findById(1L).get();
    }

    @Test
    public void findingSpecifics() {
//        Doctor doctor = repository.findById(1L).get();
//        doctor.addRating(4.3);
//        repository.save(doctor);
//        System.out.println(doctor.getRatings().size());
    }
}
