package com.plociennik.medicalclinicbackend.domain;
import javax.persistence.*;

@Entity(name = "reservations")
public class Reservation {
    private Long id;
    private String time;
    private Patient patient;
    private Doctor doctor;

    public Reservation(Long id, String time, Patient patient, Doctor doctor) {
        this.id = id;
        this.time = time;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Reservation() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @ManyToOne
    @JoinColumn(name = "patient_id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", \ntime='" + time + '\'' +
                ", \npatient=" + patient +
                ", \ndoctor=" + doctor +
                '}';
    }
}
