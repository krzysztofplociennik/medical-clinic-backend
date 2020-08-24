package com.plociennik.medicalclinicbackend.controller;
import com.plociennik.medicalclinicbackend.domain.DoctorDto;
import com.plociennik.medicalclinicbackend.domain.RatingDto;
import com.plociennik.medicalclinicbackend.exceptions.DoctorNotFound;
import com.plociennik.medicalclinicbackend.mapper.DoctorMapper;
import com.plociennik.medicalclinicbackend.mapper.RatingMapper;
import com.plociennik.medicalclinicbackend.service.DoctorService;
import com.plociennik.medicalclinicbackend.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dtr")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private RatingService ratingService;
    @Autowired
    private RatingMapper ratingMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getDoctors")
    public List<DoctorDto> getAllDoctors() {
        return doctorMapper.mapToDoctorDtoList(doctorService.getAllDoctors());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDoctor")
    public DoctorDto getDoctor(@RequestParam Long doctorId) throws DoctorNotFound {
        return doctorMapper.mapToDoctorDto(doctorService.getDoctor(doctorId).orElseThrow(DoctorNotFound::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createDoctor")
    public void createDoctor(@RequestBody DoctorDto doctorDto) {
        doctorService.saveDoctor(doctorMapper.mapToDoctor(doctorDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateDoctor")
    public DoctorDto updateDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorMapper.mapToDoctorDto(doctorService.saveDoctor(doctorMapper.mapToDoctor(doctorDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteDoctor")
    public void deleteDoctor(@RequestParam Long doctorId) {
        doctorService.deleteDoctor(doctorId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addRating")
    public void addRating(@RequestBody RatingDto ratingDto) {
        ratingService.saveRating(ratingMapper.mapToRating(ratingDto));
    }
}
