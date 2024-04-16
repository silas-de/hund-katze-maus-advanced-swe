package org.example.hundkatzemaus.domain;

import java.time.LocalDate;
import java.util.Objects;

public class HerrenlosesTier extends TierDekorierer {
    private final LocalDate erfasstAm;

    public HerrenlosesTier(Tier tierVorher, LocalDate erfasstAm) {
        super(tierVorher);
        this.erfasstAm = Objects.requireNonNull(erfasstAm);
    }

    @Override
    public String ereignisBeschreibung() {
        return "herrenlos, erfasst am " + erfasstAm;
    }

    @Override
    public Besitzer getBesitzer() {
        return BesitzerNiemand.NIEMAND;
    }
}
