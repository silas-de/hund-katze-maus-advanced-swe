package org.example.hundkatzemaus.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Fundtier extends TierDekorierer {
    private final LocalDate fundanzeigeGeschriebenAm;
    private final String fundort;

    public Fundtier(Tier tierVorher, LocalDate fundanzeigeGeschriebenAm, String fundOrt) {
        super(tierVorher);
        this.fundanzeigeGeschriebenAm = Objects.requireNonNull(fundanzeigeGeschriebenAm);
        this.fundort = Objects.requireNonNull(fundOrt);
    }

    @Override
    public String ereignisBeschreibung() {
        return "gefunden am " + fundanzeigeGeschriebenAm + " am Ort: " + fundort;
    }

    @Override
    public Besitzer getBesitzer() {
        LocalDate sechsMonateNachFundanzeige = fundanzeigeGeschriebenAm.plusMonths(6);
        LocalDate heute = LocalDate.now();
        if (heute.isAfter(sechsMonateNachFundanzeige)) {
            return BesitzerTierheim.TIERHEIM;
        } else {
            return BesitzerUnbekannt.UNBEKANNT;
        }
    }
}
