package org.example.hundkatzemaus.domain;

import java.util.Objects;

public class Abgabetier extends TierDekorierer {
    private final Abgabevertrag abgabevertragAnTierheim;

    public Abgabetier(Tier tierVorher, Abgabevertrag abgabevertragAnTierheim) {
        super(tierVorher);
        this.abgabevertragAnTierheim = Objects.requireNonNull(abgabevertragAnTierheim);
        if (abgabevertragAnTierheim.neuerBesitzer() != BesitzerTierheim.TIERHEIM) {
            throw new IllegalArgumentException("Abgabetier kann nur an Tierheim abgegeben werden");
        }
        if (abgabevertragAnTierheim.alterBesitzer().getClass() != Kontakt.class) {
            throw new IllegalArgumentException("Abgabetier kann nur von einem Kontakt abgegeben werden");
        }
    }

    @Override
    public String ereignisBeschreibung() {
        return "an Tierheim abgegeben, Abgabevertrag: " + abgabevertragAnTierheim.beschreibung();
    }

    @Override
    public Besitzer getBesitzer() {
        return BesitzerTierheim.TIERHEIM;
    }
}
