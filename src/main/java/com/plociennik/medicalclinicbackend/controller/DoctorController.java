package com.plociennik.medicalclinicbackend.controller;
import com.plociennik.medicalclinicbackend.domain.DoctorDto;
import com.plociennik.medicalclinicbackend.exceptions.DoctorNotFound;
import com.plociennik.medicalclinicbackend.mapper.DoctorMapper;
import com.plociennik.medicalclinicbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dtr")
public class DoctorController {
    @Autowired
    private DoctorService service;
    @Autowired
    private DoctorMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getDoctors")
    public List<DoctorDto> getAllDoctors() {
        return mapper.mapToDoctorDtoList(service.getAllDoctors());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDoctor")
    public DoctorDto getDoctor(@RequestParam Long doctorId) throws DoctorNotFound {
        return mapper.mapToDoctorDto(service.getDoctor(doctorId).orElseThrow(DoctorNotFound::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createDoctor")
    public void createDoctor(@RequestBody DoctorDto doctorDto) {
        service.createDoctor(mapper.mapToDoctor(doctorDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateDoctor")
    public DoctorDto updateDoctor(@RequestBody DoctorDto doctorDto) {
        return mapper.mapToDoctorDto(service.createDoctor(mapper.mapToDoctor(doctorDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteDoctor")
    public void deleteDoctor(@RequestParam Long doctorId) {
        service.deleteDoctor(doctorId);
    }
}
