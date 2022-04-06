package com.sarahdev38.angularspringmedic.repository;

import java.util.List;
import java.util.Optional;

import com.sarahdev38.angularspringmedic.model.Praticien;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PraticienRepository extends CrudRepository<Praticien, Integer> {

    Praticien findByNom(String name);

    @Query("SELECT p FROM Praticien p LEFT JOIN FETCH p.consultations c ")
    List<Praticien> findAll_JoinConsultations();

    @Query("SELECT p FROM Praticien p LEFT JOIN FETCH p.consultations c WHERE p.id = ?1")
    Optional<Praticien> findById_JoinConsultations(Integer id);

}