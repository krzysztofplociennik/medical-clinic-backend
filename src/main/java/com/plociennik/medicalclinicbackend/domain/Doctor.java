package com.plociennik.medicalclinicbackend.domain;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.*;

@Entity(name = "doctors")
public class Doctor {
    private Long id;
    private String name;
    private String mail;
    private String rating;
    private Set<Rating> ratings;
    private List<Reservation> reservations;

    public Doctor(Long id, String name, String mail, String rating, Set<Rating> ratings, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.rating = rating;
        this.ratings = ratings;
        this.reservations = reservations;
    }

    public Doctor() {
        if (ratings == null) {
            ratings = new LinkedHashSet<>();
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

    @Column(name = "rating")
    public String getRating() {
        if (ratings.size() > 0) {
            OptionalDouble optionalRating = ratings.stream().map(Rating::getValue).mapToDouble(Double::doubleValue).average();
            rating = String.format("%.2f", optionalRating.getAsDouble());
        } else {
            rating = "Not yet rated";
        }
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @OneToMany(
            targetEntity = Rating.class,
            mappedBy = "doctor",
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
            mappedBy = "doctor",
            cascade = CascadeType.REMOVE
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
