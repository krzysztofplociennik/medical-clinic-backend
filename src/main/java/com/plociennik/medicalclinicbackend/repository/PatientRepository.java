package com.plociennik.medicalclinicbackend.repository;
import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    @Override
    List<Patient> findAll();

    Patient findByName(String name);
}
