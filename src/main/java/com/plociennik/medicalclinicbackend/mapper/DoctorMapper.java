package com.plociennik.medicalclinicbackend.mapper;
import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.DoctorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {
    public Doctor mapToDoctor(final DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getName(),
                doctorDto.getMail(),
                doctorDto.getRating()
        );
    }

    public DoctorDto mapToDoctorDto(final Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getMail(),
                doctor.getRating()
        );
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctorList) {
        return doctorList.stream()
                .map(doctor -> new DoctorDto(doctor.getId(),
                        doctor.getName(),
                        doctor.getMail(),
                        doctor.getRating()))
                .collect(Collectors.toList());
    }
}
