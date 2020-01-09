package com.plociennik.medicalclinicbackend.service;
import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repository;

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Optional<Doctor> getDoctor(final Long id) {
        return repository.findById(id);
    }

    public Doctor createDoctor(final Doctor doctor) {
        return repository.save(doctor);
    }

    public void deleteDoctor(final Long id) {
        repository.deleteById(id);
    }
}
