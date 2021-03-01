package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Doctor;
import com.plociennik.medicalclinicbackend.domain.Patient;
import com.plociennik.medicalclinicbackend.domain.Rating;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
=======
import java.util.Optional;
>>>>>>> iss007-testing

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingRepositoryTestSuite {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    private long initialDoctorRepositorySize;
    private long initialPatientRepositorySize;
    private long initialRatingRepositorySize;

    @Before
    public void init() {
        initialDoctorRepositorySize = doctorRepository.count();
        initialPatientRepositorySize = patientRepository.count();
        initialRatingRepositorySize = ratingRepository.count();
        if (initialDoctorRepositorySize == 0 || initialPatientRepositorySize == 0 || initialRatingRepositorySize == 0) {
            putDummyData();
        }
    }

    @After
    public void finalCheck() {
        if (initialDoctorRepositorySize == 0 || initialPatientRepositorySize == 0 || initialRatingRepositorySize == 0) {
            deleteDummyData();
        }
        Assert.assertEquals(initialDoctorRepositorySize, doctorRepository.count());
        Assert.assertEquals(initialPatientRepositorySize, patientRepository.count());
        Assert.assertEquals(initialRatingRepositorySize, ratingRepository.count());
    }

    @Test
    public void saveAndDelete() {
        Doctor doctor = doctorRepository.findAll().stream().findFirst().get();
        long initialSizeOfDoctorRatings = doctor.getRatings().size();
        Patient patient = patientRepository.findAll().stream().findFirst().get();
        long initialSizeOfPatientRatings = patient.getRatings().size();
        Rating rating = new Rating();
        rating.setDoctor(doctor);
        rating.setPatient(patient);
        rating.setValue(2.23);
        ratingRepository.save(rating);

        Optional<Rating> searchedRating = ratingRepository.findAll().stream()
                .filter(rating1 -> rating1.getValue() == 2.23)
                .findAny();

        Assert.assertEquals(initialRatingRepositorySize + 1, ratingRepository.count());
        Assert.assertEquals(2.23, searchedRating.get().getValue(), 0.01);

<<<<<<< HEAD
        ratingRepository.delete(rating);
        long sizeAfterDeleting = ratingRepository.count();
=======
        Optional<Doctor> searchedDoctor = doctorRepository.findAll().stream()
                .filter(doctor1 -> doctor1.getName().equals(doctor.getName()))
                .findAny();
        Optional<Patient> searchedPatient = patientRepository.findAll().stream()
                .filter(patient1 -> patient1.getName().equals(patient.getName()))
                .findAny();
>>>>>>> iss007-testing

        Assert.assertEquals(initialSizeOfDoctorRatings + 1, searchedDoctor.get().getRatings().size());
        Assert.assertEquals(initialSizeOfPatientRatings + 1, searchedPatient.get().getRatings().size());

        ratingRepository.deleteById(searchedRating.get().getId());

<<<<<<< HEAD
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
=======
        Optional<Doctor> searchedDoctorAfterDeleting = doctorRepository.findAll().stream()
                .filter(doctor1 -> doctor1.getName().equals(doctor.getName()))
                .findAny();
        Optional<Patient> searchedPatientAfterDeleting = patientRepository.findAll().stream()
                .filter(patient1 -> patient1.getName().equals(patient.getName()))
                .findAny();

        Assert.assertEquals(initialSizeOfDoctorRatings, searchedDoctorAfterDeleting.get().getRatings().size());
        Assert.assertEquals(initialSizeOfPatientRatings, searchedPatientAfterDeleting.get().getRatings().size());
>>>>>>> iss007-testing
    }

    @Test
    public void editRating() {
        Optional<Rating> searchedRating = ratingRepository.findAll().stream().findAny();
        long sizeOfRatingRepositoryBeforeEditing = ratingRepository.count();
        double newValue2 = searchedRating.get().getValue() / 2 + 0.5;
        searchedRating.ifPresent(rating -> {
            rating.setValue(newValue2);
            ratingRepository.save(rating);
        });

        Assert.assertEquals(sizeOfRatingRepositoryBeforeEditing, ratingRepository.count());
        Assert.assertEquals(newValue2, ratingRepository.findById(searchedRating.get().getId()).get().getValue(), 0.01);
    }

    public void putDummyData() {
        Doctor doctor = new Doctor();
        doctor.setMail("doctorMailExample");
        doctor.setName("doctorNameExample");
        doctorRepository.save(doctor);
        Patient patient = new Patient();
        patient.setMail("patientMailExample");
        patient.setName("patientNameExample");
        patientRepository.save(patient);
        Rating rating = new Rating();
        rating.setDoctor(doctor);
        rating.setPatient(patient);
        rating.setValue(3.14);
        ratingRepository.save(rating);
    }

<<<<<<< HEAD
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
=======
    public void deleteDummyData() {
        Optional<Doctor> searchedDoctor = doctorRepository.findAll().stream()
                .filter(doctor -> doctor.getName().equals("doctorNameExample"))
                .findAny();
        Optional<Patient> searchedPatient = patientRepository.findAll().stream()
                .filter(patient -> patient.getName().equals("patientNameExample"))
                .findAny();
        Optional<Rating> searchedRating = ratingRepository.findAll().stream()
                .filter(rating -> rating.getValue() == 3.14)
                .findAny();
        searchedDoctor.ifPresent(doctor -> doctorRepository.deleteById(doctor.getId()));
        searchedPatient.ifPresent(patient -> patientRepository.deleteById(patient.getId()));
        searchedRating.ifPresent(rating -> ratingRepository.deleteById(rating.getId()));
>>>>>>> iss007-testing
    }

    @Test
    public void populate() {
        String ex = "2020-11-10 14:00:00";
        Patient patient = patientRepository.findById(575L).get();
        Doctor doctor = doctorRepository.findById(580L).get();

        Rating rating1 = new Rating(1L, 1.0, doctor, patient, ex);
        Rating rating2 = new Rating(1L, 2.0, doctor, patient, ex);
        Rating rating3 = new Rating(1L, 3.0, doctor, patient, ex);
        Rating rating4 = new Rating(1L, 4.0, doctor, patient, ex);
        Rating rating5 = new Rating(1L, 5.0, doctor, patient, ex);

        ratingRepository.saveAll(Arrays.asList(rating1, rating2, rating3, rating4, rating5));

    }
}
