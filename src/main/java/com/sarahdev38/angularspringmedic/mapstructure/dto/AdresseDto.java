package com.sarahdev38.angularspringmedic.mapstructure.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdresseDto {
    @JsonProperty("id")
    private Integer id;

    @Email
    @NotNull
    @JsonProperty("email")
    private String email;

    @JsonProperty("telephone_fixe")
    private String telephoneFixe;

    @JsonProperty("telephone_portable")
    private String telephonePortable;

    @JsonProperty("rue")
    private String rue;

    @JsonProperty("code_postal")
    private String codePostal;

    @JsonProperty("ville")
    private String ville;

    @JsonProperty("pays")
    private String pays;

    public AdresseDto() {
        this.email = "";
        this.telephoneFixe = "";
        this.telephonePortable = "";
        this.rue = "";
        this.codePostal = "";
        this.ville = "";
        this.pays = "";
    }

    public AdresseDto(String email, String telephoneFixe, String telephonePortable, String rue, String codePostal,
            String ville, String pays) {
                this.email = email;
                this.telephoneFixe = telephoneFixe;
                this.telephonePortable = telephonePortable;
                this.rue = rue;
                this.codePostal = codePostal;
                this.ville = ville;
                this.pays = pays;
    }

}
