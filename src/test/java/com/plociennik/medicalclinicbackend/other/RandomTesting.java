package com.plociennik.medicalclinicbackend.other;

import com.plociennik.medicalclinicbackend.domain.Rating;
import com.plociennik.medicalclinicbackend.repository.DoctorRepository;
import com.plociennik.medicalclinicbackend.repository.PatientRepository;
import com.plociennik.medicalclinicbackend.repository.RatingRepository;
import com.plociennik.medicalclinicbackend.repository.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomTesting {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void sizeOfRepositories() {
        System.out.println("Here are the size of repositories: \nPatients: "
        + patientRepository.count()
        + "\nDoctors: " + doctorRepository.count()
        + "\nRatings: " + ratingRepository.count()
        + "\nReservations: " + reservationRepository.count());
    }

    @Test
    public void clearNullDateDataValuesInRatings() {
        System.out.println("Number of records: " + ratingRepository.count());
        List<Long> indexes = ratingRepository.findAll().stream()
                .filter(rating -> rating.getDateTime() == null)
                .map(Rating::getId)
                .collect(Collectors.toList());

        for (Long index : indexes) {
            ratingRepository.deleteById(index);
        }
        System.out.println("Number of records: " + ratingRepository.count());
    }
}
