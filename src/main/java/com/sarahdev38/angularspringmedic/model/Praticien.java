package com.sarahdev38.angularspringmedic.model;

import java.util.ArrayList;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Praticien")
@Table(name = "praticien")
@DynamicUpdate
public class Praticien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
    private Adresse adresse;

    @JsonManagedReference
    @OneToMany(mappedBy = "praticien", targetEntity = Consultation.class, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE }, orphanRemoval = false)
    private List<Consultation> consultations = new ArrayList<>();

    public Praticien() {
        this.prenom = "";
        this.nom = "";
    }

    public Praticien(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public void addConsultation(Consultation consultation) {
        consultations.add(consultation);
        consultation.setPraticien(this);
    }

    public void removeConsultation(Consultation consultation) {
        consultations.remove(consultation);
        consultation.setPraticien(null);
    }

}