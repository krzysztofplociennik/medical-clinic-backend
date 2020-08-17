package com.plociennik.medicalclinicbackend.controller;
import com.plociennik.medicalclinicbackend.domain.PatientDto;
import com.plociennik.medicalclinicbackend.exceptions.PatientNotFound;
import com.plociennik.medicalclinicbackend.mapper.PatientMapper;
import com.plociennik.medicalclinicbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pnt")
public class PatientController {
    @Autowired
    private PatientService service;
    @Autowired
    private PatientMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "getPatients")
    public List<PatientDto> getAllPatients() {
        return mapper.mapToPatientDtoList(service.getAllPatients());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getPatient")
    public PatientDto getPatient(@RequestParam Long patientId) throws PatientNotFound {
        return mapper.mapToPatientDto(service.getPatient(patientId).orElseThrow(PatientNotFound::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createPatient")
    public void createPatient(@RequestBody PatientDto patientDto) {
        service.savePatient(mapper.mapToPatient(patientDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePatient")
    public PatientDto updatePatient(@RequestBody PatientDto patientDto) {
        return mapper.mapToPatientDto(service.savePatient(mapper.mapToPatient(patientDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePatient")
    public void deletePatient(@RequestParam Long patientId) {
        service.deletePatient(patientId);
    }
}
