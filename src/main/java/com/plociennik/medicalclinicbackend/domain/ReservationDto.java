package com.plociennik.medicalclinicbackend.domain;

import java.time.LocalDateTime;

public class ReservationDto {
    private Long id;
    private LocalDateTime time;
    private Long patientId;
    private Long doctorId;

    public ReservationDto(Long id, LocalDateTime time, Long patientId, Long doctorId) {
        this.id = id;
        this.time = time;
        this.patientId = patientId;
        this.doctorId = doctorId;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatient(Long id) {
        this.patientId = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctor(Long id) {
        this.doctorId = id;
    }
}
