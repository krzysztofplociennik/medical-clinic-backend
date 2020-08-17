package com.plociennik.medicalclinicbackend.domain;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PatientDto {
    private Long id;
    private String name;
    private String mail;
    private String phoneNumber;
    private Set<RatingDto> ratings;
    private List<ReservationDto> reservations;

    public PatientDto(Long id, String name, String mail, String phoneNumber, Set<RatingDto> ratings, List<ReservationDto> reservations) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.ratings = ratings;
        this.reservations = reservations;
    }

    public PatientDto() {
        ratings = new LinkedHashSet<>();
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

    public Set<RatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(Set<RatingDto> ratings) {
        this.ratings = ratings;
    }

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }
}
