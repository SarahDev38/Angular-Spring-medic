package com.sarahdev38.angularspringmedic.controller;

import java.util.List;

import com.sarahdev38.angularspringmedic.mapstructure.dto.AdresseDto;
import com.sarahdev38.angularspringmedic.mapstructure.dto.PraticienDto;
import com.sarahdev38.angularspringmedic.mapstructure.mappers.MapStructureMapper;
import com.sarahdev38.angularspringmedic.model.Adresse;
import com.sarahdev38.angularspringmedic.model.Consultation;
import com.sarahdev38.angularspringmedic.model.Praticien;
import com.sarahdev38.angularspringmedic.service.AdresseService;
import com.sarahdev38.angularspringmedic.service.PraticienService;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Data
@Transactional
public class PraticienController {

    private MapStructureMapper mapper = Mappers.getMapper(MapStructureMapper.class);

    @Autowired
    private final PraticienService service;
    @Autowired
    private final AdresseService adresseService;

    @GetMapping("/praticiens")
    public List<PraticienDto> getAll() {
        return mapper.praticiensToPraticienDtos(service.findPraticiens());
    }

    @GetMapping("/praticiens/consultations")
    public List<Praticien> getAllWithConsultations() {
        return service.findPraticiens_JoinConsultations();
    }

    @PostMapping("/praticiens/create")
    public void addPraticien(@RequestBody PraticienDto praticienDto) {
        service.savePraticien(mapper.praticienDtoToPraticien(praticienDto));
    }

    @PostMapping("/praticiens/{id}/adresse")
    public void addPraticienAdresse(@RequestBody AdresseDto praticienAdresseDto, @PathVariable Integer id) {
        Adresse adresse = mapper.adresseDtoToAdresse(praticienAdresseDto);
        adresse.addPraticien(service.findPraticienById(id));
        adresseService.saveAdresse(adresse);
    }

    @GetMapping("/praticiens/{id}")
    public PraticienDto GetById(@PathVariable Integer id) {
        Praticien praticien = service.findPraticienById(id);
        return mapper.praticienToPraticienDto(praticien);
    }

    @GetMapping("/praticiens/{id}/consultations")
    public List<Consultation> GetConsultationsByPraticienId(@PathVariable Integer id) {
        return service.findPraticienById_JoinConsultations(id).getConsultations();
    }
}
