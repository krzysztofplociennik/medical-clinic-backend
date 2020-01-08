package com.plociennik.medicalclinicbackend.domain;

import java.time.LocalDateTime;

public class ReservationDto {
    private Long id;
    private LocalDateTime time;
    private Patient patient;
    private Doctor doctor;

    public ReservationDto(Long id, LocalDateTime time, Patient patient, Doctor doctor) {
        this.id = id;
        this.time = time;
        this.patient = patient;
        this.doctor = doctor;
    }

    public ReservationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
