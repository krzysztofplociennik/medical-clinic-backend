package com.plociennik.medicalclinicbackend.mapper;
import com.plociennik.medicalclinicbackend.domain.Rating;
import com.plociennik.medicalclinicbackend.domain.RatingDto;
import com.plociennik.medicalclinicbackend.service.DoctorService;
import com.plociennik.medicalclinicbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RatingMapper {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    public Rating mapToRating(final RatingDto ratingDto) {
        return new Rating(
                ratingDto.getId(),
                ratingDto.getValue(),
                doctorService.getDoctor(ratingDto.getDoctorId()).get(),
                patientService.getPatient(ratingDto.getPatientId()).get(),
                ratingDto.getDateTime()
        );
    }

    public RatingDto mapToRatingDto(final Rating rating) {
        return new RatingDto(
                rating.getId(),
                rating.getValue(),
                rating.getDoctor().getId(),
                rating.getPatient().getId(),
                rating.getDateTime()
        );
    }

    public Set<RatingDto> mapToRatingDtoSet(final Set<Rating> ratingSet) {
        return ratingSet.stream()
                .map(rating -> new RatingDto(
                        rating.getId(),
                        rating.getValue(),
                        rating.getDoctor().getId(),
                        rating.getPatient().getId(),
                        rating.getDateTime()))
                .collect(Collectors.toSet());
    }

    public Set<Rating> mapToRatingSet(final Set<RatingDto> ratingDtoSet) {
        return ratingDtoSet.stream()
                .map(rating -> new Rating(
                        rating.getId(),
                        rating.getValue(),
                        doctorService.getDoctor(rating.getDoctorId()).get(),
                        patientService.getPatient(rating.getPatientId()).get(),
                        rating.getDateTime()))
                .collect(Collectors.toSet());
    }
}
