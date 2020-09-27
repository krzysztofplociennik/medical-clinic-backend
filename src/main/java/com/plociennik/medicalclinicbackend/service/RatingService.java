package com.plociennik.medicalclinicbackend.service;

import com.plociennik.medicalclinicbackend.domain.Rating;
import com.plociennik.medicalclinicbackend.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RatingService {
    @Autowired
    private RatingRepository repository;

    public Set<Rating> getAllRatings() {
        return repository.findAll();
    }

    public Optional<Rating> getRating(final Long id) {
        return repository.findById(id);
    }

    public Rating saveRating(final Rating rating) {
        return repository.save(rating);
    }

    public void deleteRating(final Long id) {
        repository.deleteById(id);
    }
}
