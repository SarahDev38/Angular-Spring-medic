package com.sarahdev38.angularspringmedic.mapstructure.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultationDto {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("titre")
    private String titre;
    @JsonProperty("commentaires")
    private String commentaires;
    @JsonProperty("date_debut")
    private Date dateDebut;
    @JsonProperty("date_fin")
    private Date dateFin;
    @JsonProperty("is_all_day")
    private Boolean isAllDay;
}
