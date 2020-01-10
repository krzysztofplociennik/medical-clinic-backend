package com.plociennik.medicalclinicbackend.service;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Optional<Patient> getPatient(final Long id) {
        return repository.findById(id);
    }

    public Patient savePatient(final Patient patient) {
        return repository.save(patient);
    }

    public void deletePatient(final Long id) {
        repository.deleteById(id);
    }
}
