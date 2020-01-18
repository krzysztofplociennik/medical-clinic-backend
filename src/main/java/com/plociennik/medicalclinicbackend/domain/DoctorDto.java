package com.plociennik.medicalclinicbackend.domain;

import java.util.ArrayList;
import java.util.List;

public class DoctorDto {
    private Long id;
    private String name;
    private String mail;
    private double rating;
    private List<ReservationDto> reservations;

    public DoctorDto(Long id, String name, String mail, double rating, List<ReservationDto> reservations) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.rating = rating;
        this.reservations = reservations;
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

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }
}
