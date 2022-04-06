package com.sarahdev38.angularspringmedic.service;

import java.util.List;

import com.sarahdev38.angularspringmedic.model.Praticien;

public interface PraticienService {

    List<Praticien> findPraticiens();

    List<Praticien> findPraticiens_JoinConsultations();

    Praticien savePraticien(Praticien praticien);

    Praticien findPraticienById(Integer id);

    Praticien findPraticienById_JoinConsultations(Integer id);

}
