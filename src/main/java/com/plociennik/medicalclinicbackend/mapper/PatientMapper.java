package com.plociennik.medicalclinicbackend.mapper;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private RatingMapper ratingMapper;

    public Patient mapToPatient(final PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getMail(),
                patientDto.getPhoneNumber(),
                patientDto.getUsername(),
                patientDto.getPassword(),
                ratingMapper.mapToRatingSet(patientDto.getRatings()),
                reservationMapper.mapToReservationList(patientDto.getReservations())
        );
    }

    public PatientDto mapToPatientDto(final Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getMail(),
                patient.getPhoneNumber(),
                patient.getUsername(),
                patient.getPassword(),
                ratingMapper.mapToRatingDtoSet(patient.getRatings()),
                reservationMapper.mapToReservationDtoList(patient.getReservations())
        );
    }

    public List<PatientDto> mapToPatientDtoList(final List<Patient> patientList) {
        return patientList.stream()
                .map(patient -> new PatientDto(
                        patient.getId(),
                        patient.getName(),
                        patient.getMail(),
                        patient.getPhoneNumber(),
                        patient.getUsername(),
                        patient.getPassword(),
                        ratingMapper.mapToRatingDtoSet(patient.getRatings()),
                        reservationMapper.mapToReservationDtoList(patient.getReservations())))
                .collect(Collectors.toList());
    }
}
