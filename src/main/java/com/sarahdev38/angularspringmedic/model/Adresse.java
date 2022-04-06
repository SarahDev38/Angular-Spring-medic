package com.sarahdev38.angularspringmedic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DynamicUpdate
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "tel_fixe")
    private String telephoneFixe;

    @Column(name = "tel_portable")
    private String telephonePortable;

    @Column(name = "rue")
    private String rue;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "pays")
    private String pays;

    @JsonManagedReference
    @OneToMany(mappedBy = "adresse", targetEntity = Patient.class, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, orphanRemoval = false)
    private List<Patient> patients = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "adresse", targetEntity = Praticien.class, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, orphanRemoval = false)
    private List<Praticien> praticiens = new ArrayList<>();

    public Adresse() {
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        patient.setAdresse(this);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
        patient.setAdresse(null);
    }

    public void addPraticien(Praticien praticien) {
        praticiens.add(praticien);
        praticien.setAdresse(this);
    }

    public void removePraticien(Praticien praticien) {
        praticiens.remove(praticien);
        praticien.setAdresse(null);
    }
}
