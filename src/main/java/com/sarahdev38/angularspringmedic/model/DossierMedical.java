package com.sarahdev38.angularspringmedic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "DossierMedical")
@Table(name = "dossier_medical")
@DynamicUpdate
class DossierMedical {

    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Patient patient;

    @Column(name = "poids")
    private Long poids;

    @Column(name = "date_poids")
    private Date datePoids;

    @Column(name = "taille")
    private Long taille;

    @Column(name = "date_taille")
    private Date dateTaille;

    @Column(name = "perimetre_cranien")
    private Long perimetreCranien;

    @Column(name = "pas")
    private Long pas; // pression_arterielle_systolique

    @Column(name = "date_pas")
    private Date datePas;

    @Column(name = "pad")
    private Long pad;

    @Column(name = "date_pad")
    private Date datePad;

    public DossierMedical() {
    }
}
