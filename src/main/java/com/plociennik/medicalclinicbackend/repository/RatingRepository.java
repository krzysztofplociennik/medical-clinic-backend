package com.plociennik.medicalclinicbackend.repository;

import com.plociennik.medicalclinicbackend.domain.Rating;
import org.springframework.data.repository.CrudRepository;

<<<<<<< HEAD
import java.util.Set;
=======
import java.util.List;
>>>>>>> iss007-testing

public interface RatingRepository extends CrudRepository<Rating, Long> {
    @Override
    Set<Rating> findAll();
}
