package com.sarahdev38.angularspringmedic.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Consultation")
@Table(name = "consultation")
@DynamicUpdate
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "commentaires")
    private String commentaires;

    @Column(name = "date_debut")
    private LocalDateTime dateDebut;

    @Column(name = "date_fin")
    private LocalDateTime dateFin;

    @Column(name = "is_all_day")
    private Boolean isAllDay;

    @ElementCollection(targetClass = Acte.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "consultation_acte", joinColumns = @JoinColumn(name = "consultation_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "actes")
    private List<Acte> actes = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "praticien_id", referencedColumnName = "id")
    private Praticien praticien;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @OneToOne(mappedBy = "consultation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @PrimaryKeyJoinColumn
    private Facturation facturation;

    public Consultation() {
        this.titre = "";
        this.commentaires = "";
        this.dateDebut = LocalDateTime.now();
        this.dateFin = dateDebut.plusHours(1L);
        this.isAllDay = false;
    }

    public Consultation(String titre, String commentaires, LocalDateTime dateDebut, LocalDateTime dateFin,
            Boolean isAllDay) {
        this.titre = titre;
        this.commentaires = commentaires;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.isAllDay = isAllDay;
    }

}