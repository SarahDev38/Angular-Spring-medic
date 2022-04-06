package com.sarahdev38.angularspringmedic.service;

import java.util.ArrayList;
import java.util.List;

import com.sarahdev38.angularspringmedic.model.Patient;
import com.sarahdev38.angularspringmedic.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Patient> findPatients() {
        log.info("call get all patients");
        List<Patient> patients = new ArrayList<>();
        repository.findAll().forEach(patients::add);
        return patients;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> findPatients_JoinConsultations() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public Patient savePatient(Patient patient) {
        log.info("call save patient");
        return repository.save(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public Patient findPatientById(Integer id) {
        log.info("call get patient by id : " + id);
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Patient findPatientById_JoinConsultations(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

}
