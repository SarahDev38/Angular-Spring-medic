package com.sarahdev38.angularspringmedic.service;

import java.util.ArrayList;
import java.util.List;

import com.sarahdev38.angularspringmedic.model.Consultation;
import com.sarahdev38.angularspringmedic.repository.ConsultationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
class ConsultationServiceImpl implements ConsultationService {
    @Autowired
    private ConsultationRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Consultation> findConsultations() {
        log.info("call get all consultations");
        List<Consultation> consultations = new ArrayList<>();
        repository.findAll().forEach(consultations::add);
        return consultations;
    }

    @Override
    @Transactional
    public Consultation saveConsultation(Consultation consultation) {
        log.info("call save consultation");
        return repository.save(consultation);
    }

    @Override
    @Transactional(readOnly = true)
    public Consultation findConsultationById(Integer id) {
        log.info("call get consultation by id : " + id);
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid consultation Id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Consultation> findConsultationByPraticienId(Integer praticienId) {
        return (List<Consultation>) repository.findByPraticienId(praticienId);
    }

    @Override
    @Transactional(readOnly = true)
    public void removeConsultation(Integer id) {
        repository.deleteById(id);
    }
}
