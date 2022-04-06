package com.sarahdev38.angularspringmedic.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.sarahdev38.angularspringmedic.model.Consultation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ConsultationRepository extends CrudRepository<Consultation, Integer> {

    List<Consultation> findByPraticienId(Integer PraticienId);

    @Query(value = "SELECT * FROM Consultation c JOIN (SELECT * FROM Praticien) AS p ON p.id = c.praticien_id", nativeQuery = true)
    List<Consultation> findAll_JoinPraticien();

 /*    @Query("SELECT c FROM Consultation c LEFT JOIN FETCH c.praticien_id p  WHERE c.id = ?1")
    Consultation findById_JoinPraticien(Integer id);
 */
}
