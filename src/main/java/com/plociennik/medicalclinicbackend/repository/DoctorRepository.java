package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    @Override
    List<Doctor> findAll();
}
