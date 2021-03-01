package com.plociennik.medicalclinicbackend.controller;

import com.plociennik.medicalclinicbackend.domain.RatingDto;
import com.plociennik.medicalclinicbackend.mapper.RatingMapper;
import com.plociennik.medicalclinicbackend.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/rate")
public class RatingController {
    @Autowired
    private RatingService service;
    @Autowired
    private RatingMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getRatings")
    public List<RatingDto> getAllRatings() {
        return mapper.mapToRatingDtoSet(service.getAllRatings());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteRating")
    public void deleteRating(@RequestParam Long ratingId) {
        service.deleteRating(ratingId);
    }
}
