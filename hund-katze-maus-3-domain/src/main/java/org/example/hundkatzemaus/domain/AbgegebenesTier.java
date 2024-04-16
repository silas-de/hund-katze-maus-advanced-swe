package org.example.hundkatzemaus.domain;

import java.util.Objects;

public class AbgegebenesTier extends TierDekorierer {
    private final Abgabevertrag abgabevertragVonTierheim;

    public AbgegebenesTier(Tier tierVorher, Abgabevertrag abgabevertragVonTierheim) {
        super(tierVorher);
        this.abgabevertragVonTierheim = Objects.requireNonNull(abgabevertragVonTierheim);
    }

    @Override
    public String ereignisBeschreibung() {
        return "von Tierheim abgegeben, Abgabevertrag: " + abgabevertragVonTierheim.beschreibung();
    }

    @Override
    public Besitzer getBesitzer() {
        return abgabevertragVonTierheim.neuerBesitzer();
    }
}
