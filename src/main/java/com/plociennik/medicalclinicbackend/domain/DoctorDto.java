package com.plociennik.medicalclinicbackend.domain;
import java.util.*;

public class DoctorDto {
    private Long id;
    private String name;
    private String mail;
    private String rating;
    private List<RatingDto> ratings;
    private List<ReservationDto> reservations;

    public DoctorDto(Long id, String name, String mail, String rating, List<RatingDto> ratings, List<ReservationDto> reservations) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.rating = rating;
        this.ratings = ratings;
        this.reservations = reservations;
    }

    public DoctorDto() {
        ratings = new ArrayList<>();
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

    public String getRating() {
        OptionalDouble optionalRating = ratings.stream().map(RatingDto::getValue).mapToDouble(Double::doubleValue).average();
        if (optionalRating.isPresent()) {
            rating = String.format("%.2f", optionalRating.getAsDouble());
        } else {
            rating = "Not yet rated";
        }
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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
}
