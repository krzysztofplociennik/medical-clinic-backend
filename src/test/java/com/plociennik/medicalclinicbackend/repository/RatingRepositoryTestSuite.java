package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.Rating;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingRepositoryTestSuite {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void findingSize() {
        long size = ratingRepository.count();
        System.out.println("\nHere's the total number of ratings: " + size);
    }

    @Test
    public void savingRating() {
        long initialSize = ratingRepository.count();

        Rating rating = new Rating();
        ratingRepository.save(rating);
        long sizeAfterSaving = ratingRepository.count();

        Assert.assertEquals(initialSize + 1, sizeAfterSaving);
        //Clean up
        ratingRepository.delete(rating);
    }

    @Test
    public void deletingRating() {
        long initialSize = ratingRepository.count();

        Rating rating = new Rating();
        ratingRepository.save(rating);

        long sizeAfterSaving = ratingRepository.count();

        Assert.assertEquals(initialSize + 1, sizeAfterSaving);

        ratingRepository.delete(rating);
        long sizeAfterDeleting = ratingRepository.count();

        Assert.assertEquals(initialSize, sizeAfterDeleting);
    }

    @Test
    public void checkingDoctorAndPatientRatingsAfterSavingRating() {
        long initialSizeOfRatings = ratingRepository.count();
        Doctor doctor = doctorRepository.findById(1L).get();
        int sizeOfDoctorsRatingsBeforeSaving = doctor.getRatings().size();
        Patient patient = patientRepository.findById(1L).get();
        int sizeOfPatientsRatingsBeforeSaving = patient.getRatings().size();

        Rating rating = new Rating();
        rating.setValue(5.0);
        rating.setDoctor(doctor);
        rating.setPatient(patient);
        ratingRepository.save(rating);
        doctorRepository.save(doctor);
        patientRepository.save(patient);

        int sizeOfDoctorsRatingsAfterSaving = doctor.getRatings().size();
        int sizeOfPatientsRatingsAfterSaving = patient.getRatings().size();

        Assert.assertEquals(sizeOfDoctorsRatingsBeforeSaving + 1, sizeOfDoctorsRatingsAfterSaving);
        Assert.assertEquals(sizeOfPatientsRatingsBeforeSaving + 1, sizeOfPatientsRatingsAfterSaving);

        //Clean up
        ratingRepository.delete(rating);
    }

    @Test
    public void saveRatingWithoutDeleting() {
        Doctor doctor = doctorRepository.findById(1L).get();
        Patient patient = patientRepository.findById(1L).get();

        Rating rating = new Rating();
        rating.setValue(2.334421);
        rating.setDoctor(doctor);
        rating.setPatient(patient);
        ratingRepository.save(rating);
    }

    @Test
    public void displayRatings() {
        Doctor doctor = doctorRepository.findById(1L).get();
        Patient patient = patientRepository.findById(1L).get();
        doctor.setRating(doctor.getRating());

        List<Double> sortedDoctorSet = doctor.getRatings().stream().map(Rating::getValue).sorted().collect(Collectors.toList());
        List<Double> sortedPatientSet = patient.getRatings().stream().map(Rating::getValue).sorted().collect(Collectors.toList());

        System.out.println("Here are doctor's ratings: ");
        for (Double rating : sortedDoctorSet) {
            System.out.println("rating = " + rating);
        }

        System.out.println("And here's his average rating: " + doctor.getRating());

        System.out.println("\nHere are patient's ratings: ");
        for (Double rating : sortedPatientSet) {
            System.out.println("rating = " + rating);
        }
    }
}
