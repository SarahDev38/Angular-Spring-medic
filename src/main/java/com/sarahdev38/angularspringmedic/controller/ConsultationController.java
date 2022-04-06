package com.sarahdev38.angularspringmedic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.sarahdev38.angularspringmedic.mapstructure.dto.ConsultationDto;
import com.sarahdev38.angularspringmedic.mapstructure.mappers.MapStructureMapper;
import com.sarahdev38.angularspringmedic.model.Consultation;
import com.sarahdev38.angularspringmedic.service.ConsultationService;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Data
@Transactional
public class ConsultationController {

    private MapStructureMapper mapper = Mappers.getMapper(MapStructureMapper.class);

    @Autowired
    private final ConsultationService service;

    @GetMapping("/consultations")
    public List<ConsultationDto> getAll() {
        List<ConsultationDto> consultationsDto = new ArrayList<>();
        service.findConsultations().forEach(
                consultation -> consultationsDto.add(mapper.consultationToConsultationDto(consultation)));
                //changer pour ConsultationsDto: List<ConsultationDto>
        return consultationsDto;
    }

    @PostMapping("/consultations/create")
    public void addConsultation(@RequestBody Consultation consultation) {
        service.saveConsultation(consultation);
    }

    @GetMapping("/consultations/praticiens/{id}")
    public List<Consultation> getConsultationsByPraticien(@PathVariable Integer id) {
        return service.findConsultationByPraticienId(id);
    }

    @PutMapping("/consultations/{id}/update")
    public void UpdateConsultation(@RequestBody Consultation consultation) {
        service.saveConsultation(consultation);
    }

    @DeleteMapping("/consultations/{id}/delete")
    public void DeletePost(@PathVariable Integer id) {
        service.removeConsultation(id);
    }
}
