package com.sarahdev38.angularspringmedic.mapstructure.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("prenom")
    private String prenom;
    @JsonProperty("ddn")
    private Date ddn;

    public PatientDto() {
        this.nom = "";
        this.prenom = "";
        this.ddn = new Date();
    }

    public PatientDto(String nom, String prenom, Date ddn) {
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
    }
}
