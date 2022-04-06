package com.sarahdev38.angularspringmedic.repository;

import com.sarahdev38.angularspringmedic.model.Adresse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends CrudRepository<Adresse, Integer> {

}