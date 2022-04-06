package com.sarahdev38.angularspringmedic.service;

import java.util.List;

import com.sarahdev38.angularspringmedic.model.Patient;

public interface PatientService {

    List<Patient> findPatients();

    List<Patient> findPatients_JoinConsultations();

    Patient savePatient(Patient patient);

    Patient findPatientById(Integer id);

    Patient findPatientById_JoinConsultations(Integer id);

}
