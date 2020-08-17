package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Reservation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryTestSuite {
    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void findingSize() {
        long size = reservationRepository.count();
        System.out.println("\nHere's the total number of reservations: " + size);
    }

    @Test
    public void savingReservation() {
        long initialSize = reservationRepository.count();

        Reservation reservation = new Reservation();
        reservationRepository.save(reservation);
        long sizeAfterSaving = reservationRepository.count();

        Assert.assertEquals(initialSize + 1, sizeAfterSaving);
        //Clean up
        reservationRepository.delete(reservation);
    }

    @Test
    public void deletingReservation() {
        long initialSize = reservationRepository.count();

        Reservation reservation = new Reservation();
        reservationRepository.save(reservation);
        Long id = reservationRepository.findAll().get((int) initialSize).getId();

        long sizeAfterSaving = reservationRepository.count();

        Assert.assertEquals(initialSize + 1, sizeAfterSaving);

        reservationRepository.deleteById(id);
        long sizeAfterDeleting = reservationRepository.count();

        Assert.assertEquals(initialSize, sizeAfterDeleting);
    }
}
