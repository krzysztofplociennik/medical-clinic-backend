package com.plociennik.medicalclinicbackend.domain;

public class Doctor {
    private Long id;
    private String name;
    private String mail;
    private double rating;

    public Doctor(Long id, String name, String mail, double rating) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.rating = rating;
    }

    public Doctor() {
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
