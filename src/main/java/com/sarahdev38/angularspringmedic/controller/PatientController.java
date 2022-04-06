package com.sarahdev38.angularspringmedic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.sarahdev38.angularspringmedic.mapstructure.dto.PatientDto;
import com.sarahdev38.angularspringmedic.mapstructure.mappers.MapStructureMapper;
import com.sarahdev38.angularspringmedic.model.Patient;
import com.sarahdev38.angularspringmedic.service.PatientService;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Data
@Transactional
public class PatientController {

    private MapStructureMapper mapper = Mappers.getMapper(MapStructureMapper.class);

    @Autowired
    private final PatientService service;

    @GetMapping("/patients")
    public List<PatientDto> getAll() {
        List<PatientDto> patientsDto = new ArrayList<>();
        service.findPatients().forEach(
                patient -> patientsDto.add(mapper.patientToPatientDto(patient)));
        // changer pour PatientsDto: List<PatientDto>
        return patientsDto;
    }

    @GetMapping("/patients/consultations")
    public List<Patient> getAllWithConsultations() {
        return service.findPatients_JoinConsultations();
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient) {
        service.savePatient(patient);
    }
}
