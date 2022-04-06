package com.sarahdev38.angularspringmedic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Patient")
@Table(name = "patient")
@DynamicUpdate
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private Date ddn;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private DossierMedical dossierMedical;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private DossierFacturation dossierFacturation;

    @JsonManagedReference
    @OneToMany(mappedBy = "patient", targetEntity = Consultation.class, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, orphanRemoval = true)
    private List<Consultation> consultations = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
    private Adresse adresse;

    public Patient() {
        this.nom = "";
        this.prenom = "";
        this.ddn = new Date();
    }

    public Patient(String nom, String prenom, Date ddn) {
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
    }

    public void addConsultation(Consultation consultation) {
        consultations.add(consultation);
        consultation.setPatient(this);
    }

    public void removeConsultation(Consultation consultation) {
        consultations.remove(consultation);
        consultation.setPatient(null);
    }

}