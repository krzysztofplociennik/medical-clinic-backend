package com.plociennik.medicalclinicbackend.domain;

import java.util.ArrayList;
import java.util.List;

public class DoctorDto {
    private Long id;
    private String name;
    private String mail;
    private double rating;
    private List<Reservation> reservations = new ArrayList<>();

    public DoctorDto(Long id, String name, String mail, double rating) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.rating = rating;
    }

    public DoctorDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
