package com.plociennik.medicalclinicbackend.mapper;
import com.plociennik.medicalclinicbackend.domain.Reservation;
import com.plociennik.medicalclinicbackend.domain.ReservationDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {

    public Reservation mapToReservation(final ReservationDto reservationDto) {
            return new Reservation(
                    reservationDto.getId(),
                    reservationDto.getTime(),
                    reservationDto.getPatient(),
                    reservationDto.getDoctor()
            );
    }

    public ReservationDto mapToReservationDto(final Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getTime(),
                reservation.getPatient(),
                reservation.getDoctor()
        );
    }

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservationList) {
        return reservationList.stream()
                .map(reservation -> new ReservationDto(reservation.getId(),
                                                        reservation.getTime(),
                                                        reservation.getPatient(),
                                                        reservation.getDoctor()))
                .collect(Collectors.toList());
    }
}
