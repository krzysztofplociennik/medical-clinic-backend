package com.plociennik.medicalclinicbackend.domain;

import java.util.ArrayList;
import java.util.List;

public class PatientDto {
    private Long id;
    private String name;
    private String mail;
    private String phoneNumber;
    private String username;
    private String password;
    private List<RatingDto> ratings;
    private List<ReservationDto> reservations;

    public PatientDto(Long id, String name, String mail, String phoneNumber, String username, String password,
                      List<RatingDto> ratings, List<ReservationDto> reservations) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.ratings = ratings;
        this.reservations = reservations;
    }

    public PatientDto() {
        ratings = new ArrayList<>();
        reservations = new ArrayList<>();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDto> ratings) {
        this.ratings = ratings;
    }

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", \nname='" + name + '\'' +
                ", \nmail='" + mail + '\'' +
                ", \nphoneNumber='" + phoneNumber + '\'' +
                ", \nusername='" + username + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nratings=" + ratings +
                ", \nreservations=" + reservations +
                '}';
    }
}
