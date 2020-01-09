package com.plociennik.medicalclinicbackend;
import com.plociennik.medicalclinicbackend.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {
    @Autowired
    private ReservationService service;
    @Test
    public void whatever() {
        //Reservation reservation = new Reservation();
        //reservationRepository.save(reservation);
        System.out.println(service.getAllReservations().size());
    }
}
