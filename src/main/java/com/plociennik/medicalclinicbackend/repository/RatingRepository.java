package com.plociennik.medicalclinicbackend.repository;
import com.plociennik.medicalclinicbackend.domain.Rating;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    @Override
    List<Rating> findAll();
}
