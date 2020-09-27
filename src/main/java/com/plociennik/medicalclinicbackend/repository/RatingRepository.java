package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Rating;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    @Override
    Set<Rating> findAll();
}
