package com.sarahdev38.angularspringmedic.model;

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
@Entity(name = "DossierFacturation")
@Table(name = "dossier_facturation")
@DynamicUpdate
public class DossierFacturation {
    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Patient patient;

    @Column(name = "numero_secu")
    private String numeroSS;
    @Column(name = "nom_mutuelle")
    private String mutuelle;
    @Column(name = "numero_assure")
    private String NumeroAssure;

    public DossierFacturation() {
    }
}
