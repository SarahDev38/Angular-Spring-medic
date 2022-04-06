package com.sarahdev38.angularspringmedic.service;

import com.sarahdev38.angularspringmedic.model.Adresse;

public interface AdresseService {

    Adresse saveAdresse(Adresse adresse);

    Adresse findAdresseById(Integer id);
}
