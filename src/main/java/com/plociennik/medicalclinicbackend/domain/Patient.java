package com.plociennik.medicalclinicbackend.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "patients")
public class Patient {
    private Long id;
    private String name;
    private String mail;
    private String phoneNumber;
    private List<Reservation> reservations = new ArrayList<>();

    public Patient(Long id, String name, String mail, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public Patient() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
