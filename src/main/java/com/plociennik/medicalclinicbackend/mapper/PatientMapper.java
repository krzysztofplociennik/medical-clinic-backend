package com.plociennik.medicalclinicbackend.mapper;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.PatientDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
    public Patient mapToPatient(final PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getMail(),
                patientDto.getPhoneNumber()
        );
    }

    public PatientDto mapToPatientDto(final Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getMail(),
                patient.getPhoneNumber()
        );
    }

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patientList) {
        return patientList.stream()
                .map(patient -> new PatientDto(patient.getId(),
                        patient.getName(),
                        patient.getMail(),
                        patient.getPhoneNumber()))
                .collect(Collectors.toList());
    }
}
