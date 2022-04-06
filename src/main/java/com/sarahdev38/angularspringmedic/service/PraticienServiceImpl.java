package com.sarahdev38.angularspringmedic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sarahdev38.angularspringmedic.model.Praticien;
import com.sarahdev38.angularspringmedic.repository.PraticienRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
class PraticienServiceImpl implements PraticienService {
    @Autowired
    private PraticienRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Praticien> findPraticiens() {
        log.info("call get all praticiens");
        List<Praticien> praticiens = new ArrayList<>();
        repository.findAll().forEach(praticiens::add);
        return praticiens;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Praticien> findPraticiens_JoinConsultations() {
        log.info("call get all praticiens with consultations");
        return repository.findAll_JoinConsultations();
    }

    @Override
    @Transactional
    public Praticien savePraticien(Praticien praticien) {
        log.info("call save praticien");
        return repository.save(praticien);
    }

    @Override
    @Transactional(readOnly = true)
    public Praticien findPraticienById(Integer id) {
        log.info("call get praticien with id : " + id);
        Optional<Praticien> praticien = repository.findById(id);
        if (praticien.isPresent())
            return praticien.get();
        else
            return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Praticien findPraticienById_JoinConsultations(Integer id) {
        log.info("call get praticien with consultations with id : " + id);
        Optional<Praticien> praticien = repository.findById_JoinConsultations(id);
        if (praticien.isPresent()) {
            return praticien.get();
        } else {
            return null;
        }
    }

}
