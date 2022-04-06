package com.sarahdev38.angularspringmedic.service;

import java.util.List;

import com.sarahdev38.angularspringmedic.model.Consultation;

public interface ConsultationService {

    List<Consultation> findConsultations();

    Consultation saveConsultation(Consultation consultation);

    Consultation findConsultationById(Integer id);

    List<Consultation> findConsultationByPraticienId(Integer praticienId);

    void removeConsultation(Integer id);
}
