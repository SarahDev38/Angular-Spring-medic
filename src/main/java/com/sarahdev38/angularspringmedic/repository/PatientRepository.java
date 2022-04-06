package com.sarahdev38.angularspringmedic.repository;

import java.util.List;

import com.sarahdev38.angularspringmedic.model.Patient;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    Patient findByNom(String nom);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.consultations c ")
    List<Patient> findAll_JoinConsultations();

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.consultations c WHERE p.id = ?1")
    Patient findById_JoinConsultations(Integer id);
}
