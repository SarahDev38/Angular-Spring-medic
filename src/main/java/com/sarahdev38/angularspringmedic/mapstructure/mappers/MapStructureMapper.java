package com.sarahdev38.angularspringmedic.mapstructure.mappers;

import java.util.List;

import com.sarahdev38.angularspringmedic.mapstructure.dto.ConsultationDto;
import com.sarahdev38.angularspringmedic.mapstructure.dto.PatientDto;
import com.sarahdev38.angularspringmedic.mapstructure.dto.AdresseDto;
import com.sarahdev38.angularspringmedic.mapstructure.dto.PraticienDto;
import com.sarahdev38.angularspringmedic.model.Adresse;
import com.sarahdev38.angularspringmedic.model.Consultation;
import com.sarahdev38.angularspringmedic.model.Patient;
import com.sarahdev38.angularspringmedic.model.Praticien;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructureMapper {

    PraticienDto praticienToPraticienDto(Praticien praticien);

    List<PraticienDto> praticiensToPraticienDtos(List<Praticien> praticiens);

    Praticien praticienDtoToPraticien(PraticienDto praticienDto);

    Adresse adresseDtoToAdresse(AdresseDto adresseDto);

    PatientDto patientToPatientDto(Patient patient);

    ConsultationDto consultationToConsultationDto(Consultation consultation);

}
