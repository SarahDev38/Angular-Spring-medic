package com.sarahdev38.angularspringmedic.mapstructure.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PraticienDto {
    @JsonProperty("id")
    private Integer id;

    @NotNull
    @JsonProperty("nom")
    private String nom;
    
    @NotNull
    @JsonProperty("prenom")
    private String prenom;

    public PraticienDto() {
        this.prenom = "";
        this.nom = "";
    }

    public PraticienDto(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

}
