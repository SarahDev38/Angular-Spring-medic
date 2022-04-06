package com.sarahdev38.angularspringmedic.service;

import java.util.Optional;

import com.sarahdev38.angularspringmedic.model.Adresse;
import com.sarahdev38.angularspringmedic.repository.AdresseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
class AdresseServiceImpl implements AdresseService {
    @Autowired
    private AdresseRepository repository;

    @Override
    @Transactional
    public Adresse saveAdresse(Adresse adresse) {
        log.info("call save adresse");
        return repository.save(adresse);
    }

    @Override
    @Transactional(readOnly = true)
    public Adresse findAdresseById(Integer id) {
        log.info("call get adresse with id : " + id);
        Optional<Adresse> adresse = repository.findById(id);
        if (adresse.isPresent())
            return adresse.get();
        else
            return null;
    }

}
