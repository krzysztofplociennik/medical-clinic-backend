package com.plociennik.medicalclinicbackend.mapper;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.domain.ReservationDto;
import com.plociennik.medicalclinicbackend.service.DoctorService;
import com.plociennik.medicalclinicbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    public Reservation mapToReservation(final ReservationDto reservationDto) {
            return new Reservation(
                    reservationDto.getId(),
                    reservationDto.getTime(),
                    patientService.getPatient(reservationDto.getPatientId()).get(),
                    doctorService.getDoctor(reservationDto.getDoctorId()).get()
            );
    }

    public ReservationDto mapToReservationDto(final Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getTime(),
                reservation.getPatient().getId(),
                reservation.getDoctor().getId()
        );
    }

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservations) {
        return reservations.stream()
                .map(reservation -> new ReservationDto(
                        reservation.getId(),
                        reservation.getTime(),
                        reservation.getPatient().getId(),
                        reservation.getDoctor().getId()))
                .collect(Collectors.toList());
    }

    public List<Reservation> mapToReservationList(final List<ReservationDto> reservations) {
        return reservations.stream()
                .map(reservationDto -> new Reservation(
                        reservationDto.getId(),
                        reservationDto.getTime(),
                        patientService.getPatient(reservationDto.getPatientId()).get(),
                        doctorService.getDoctor(reservationDto.getDoctorId()).get()))
                .collect(Collectors.toList());
    }
}
