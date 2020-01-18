package com.plociennik.medicalclinicbackend.mapper;
import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {
    @Autowired
    private ReservationMapper reservationMapper;

    public Doctor mapToDoctor(final DoctorDto doctorDto) {
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getName(),
                doctorDto.getMail(),
                doctorDto.getRating(),
                reservationMapper.mapToReservationList(doctorDto.getReservations())
        );
    }

    public DoctorDto mapToDoctorDto(final Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getMail(),
                doctor.getRating(),
                reservationMapper.mapToReservationDtoList(doctor.getReservations())
        );
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctorList) {
        return doctorList.stream()
                .map(doctor -> new DoctorDto(doctor.getId(),
                        doctor.getName(),
                        doctor.getMail(),
                        doctor.getRating(),
                        reservationMapper.mapToReservationDtoList(doctor.getReservations())))
                .collect(Collectors.toList());
    }
}
