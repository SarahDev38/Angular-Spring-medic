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
@Entity(name = "Facturation")
@Table(name = "facturation")
@DynamicUpdate
public class Facturation {
    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    private Consultation consultation;

    @Column(name = "montant_facture")
    private Long montantFacture;
    @Column(name = "base_remboursement")
    private Long baseRemboursement;
    @Column(name = "montant_réglé")
    private Long montantRegle;

    public Facturation() {
    }
}
