package com.plociennik.medicalclinicbackend.domain;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "patients")
public class Patient {
    private Long id;
    private String name;
    private String mail;
    private String phoneNumber;
    private String username;
    private String password;
    private Set<Rating> ratings;
    private List<Reservation> reservations;

    public Patient(Long id,
                   String name,
                   String mail,
                   String phoneNumber,
                   String username,
                   String password,
                   Set<Rating> ratings,
                   List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.ratings = ratings;
        this.reservations = reservations;
    }

    public Patient() {
        if (ratings == null) {
            ratings = new LinkedHashSet<>();
        }
        if (reservations == null) {
            reservations = new ArrayList<>();
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "phone_number")
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

    @OneToMany(
            targetEntity = Rating.class,
            mappedBy = "patient",
            cascade = CascadeType.REMOVE
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "patient",
            cascade = CascadeType.REMOVE
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Patient{" +
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
