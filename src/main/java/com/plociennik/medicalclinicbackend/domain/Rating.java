package com.plociennik.medicalclinicbackend.domain;
import javax.persistence.*;

@Entity
public class Rating {
    private Long id;
    private double value;
    private Doctor doctor;
    private Patient patient;
    private String dateTime;

    public Rating(Long id, double value, Doctor doctor, Patient patient, String dateTime) {
        this.id = id;
        this.value = value;
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
    }

    public Rating() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @ManyToOne
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @ManyToOne
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", \nvalue=" + value +
                ", \ndoctor=" + doctor +
                ", \npatient=" + patient +
                ", \ndateTime='" + dateTime + '\'' +
                '}';
    }
}
