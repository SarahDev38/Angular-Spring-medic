package com.sarahdev38.angularspringmedic.model;

import lombok.Getter;

@Getter
enum Acte {
    C("consultation au cabinet", 23),
    G("consultation au cabinet majorée de la majoration pour le médecin généraliste", 25),
    CS("consultation au cabinet par le médecin spécialiste qualifié en médecine générale", 23),
    GS("consultation au cabinet par le médecin spécialiste qualifié en médecine générale avec la majoration pour le médecin généraliste",
            25),
    TCG("consultation à distance réalisée entre un médecin généraliste et un patient (téléconsultation)", 25),
    TC("consultation à distance réalisée entre un médecin généraliste et un patient (téléconsultation), dans le cas où le médecin n’est pas dans les situations où il peut facturer le TCG",
            23),
    TE2("acte de téléexpertise d’un médecin sollicité par un autre médecin", 20),
    RQD("acte de demande d’une téléexpertise par un professionnel de santé auprès d’un médecin", 10),
    APC("avis ponctuel de consultant au cabinet (ou à domicile)", 55),
    MCG("majoration de coordination", 5),
    MUT("majoration d'urgence du médecin traitant (uniquement si la consultation associée est réalisée à tarif opposable)",
            5),
    MCU("majoration correspondant urgence (uniquement si consultation associée réalisée à tarif opposable)", 15),
    MRT("majoration médecin traitant (uniquement si la consultation associée est réalisée à tarif opposable)", 15),
    RMT("rémunération spécifique annuelle pour un patient en ALD", 40),
    FMT("forfait médecin traitant pour les patients hors ALD (2)", 5),
    MPA("rémunération forfaitaire pour les patients âgés", 5),
    V("visite à domicile", 23),
    VG("visite à domicile par le médecin généraliste majorée de la majoration pour le médecin généraliste", 25),
    VS("visite à domicile par le médecin spécialiste qualifié en médecine générale", 23),
    VGS("visite à domicile par le médecin spécialiste qualifié en médecine générale majorée de la majoration pour le médecin généraliste",
            25),
    VL("visite longue et complexe réalisée au domicile", 60),
    MD("majoration de déplacement pour visite à domicile justifiée", 10),
    MDN("majoration de déplacement pour visite à domicile justifiée de nuit de 20h00 à 00h00 et de 06h00 à 08h00",
            38.5),
    MDI("majoration de déplacement pour visite à domicile justifiée de nuit de 00h00 à 06h00", 43.5),
    MDD("majoration de déplacement pour visite à domicile justifiée de dimanche et jour férié", 22.6),
    ID("indemnité forfaitaire de déplacement pour des actes effectués à domicile autre que la visite", 3.50),
    MN("majoration pour acte de nuit de 20h00 à 00h00 et de 06h00 à 08h00", 35),
    MM("majoration pour acte de nuit de 00h00 à 06h00", 40),
    F("majoration pour acte le dimanche et jour férié", 19.06),
    CRN("majoration spécifique de nuit 20h00 à 0h00/06h00 à 08h00 en cas de consultation au cabinet, permanence des soins dans le cadre de la régulation",
            42.50),
    VRN("majoration spécifique de nuit 20h00 à 00h00/06h00 à 08h00 en cas de visite, permanence des soins dans le cadre de la régulation",
            46),
    CRM("majoration spécifique de milieu de nuit 00h00 à 06h00 en cas de consultation au cabinet, permanence des soins dans le cadre de la régulation",
            51.50),
    VRM("majoration spécifique de milieu de nuit 00h00 à 06h00 en cas de visite, permanence des soins dans le cadre de la régulation",
            59.50),
    CRD("majoration spécifique de dimanche et jours fériés en cas de consultation au cabinet, permanence des soins dans le cadre de la régulation",
            26.50),
    VRD("majoration spécifique de dimanche et jours fériés en cas de visite, permanence des soins dans le cadre de la régulation",
            30),
    IKplaine("indemnité kilométrique en plaine", 0.61),
    IKmontagne("indemnité kilométrique en montagne", 0.91),
    IKpied("indemnité kilométrique à pied ou à ski", 4.57),
    COE("consultation pour les examens obligatoires dans les 8 jours qui suivent la naissance, au cours du 9e ou du 10e mois, et au cours du 24eou du 25e mois (uniquement à tarif opposable)",
            46),
    COD("examen obligatoire de l’enfant hors COE (0-6 ans)", 30),
    COB("examen obligatoire de l’enfant (6 ans et plus)", 25),
    COG("examen obligatoire de l’enfant hors COE (0-6 ans) pour les secteurs 2 non Optam avec dépassement", 28),
    COA("examen obligatoire de l’enfant (6 ans et plus) pour les secteurs 2 non Optam avec dépassement", 23),
    CCP("première consultation de santé sexuelle, de contraception et de prévention des maladies sexuellement transmissibles",
            46),
    CCX("code prestation agrégé pour la consultation complexe CSO (7), CSE (8) et ASE (8bis)", 46),
    MTX("majoration pour consultations très complexes (MIS et PIV) (9) (1bis)", 30),
    CCE("code prestation agrégé pour la consultation très complexes CTE  et MPH ", 60),
    MEG("majoration pour les enfants de 0 à 6 ans", 5),
    MIC("majoration pour consultation d'un patient insuffisant cardiaque après hospitalisation par le médecin traitant (article 15.5 de la NGAP) si consultation réalisée au tarif opposable (1ter)",
            23),
    MSH("majoration pour la consultation de suivi de sortie d'hospitalisation de court séjour des patients à forte comorbidité par le médecin traitant (article 15.6 de la NGAP) si consultation réalisée au tarif opposable (1ter)",
            23),
    MU("majoration d'urgence", 22.60);

    private String libelle;
    private double montant;

    private Acte(String libelle, double montant) {
        this.libelle = libelle;
        this.montant = montant;
    }

    private Acte(String libelle, int montant) {
        this.libelle = libelle;
        this.montant = montant;
    }
}
