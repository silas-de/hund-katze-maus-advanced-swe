package org.example.hundkatzemaus.domain;

import java.util.Date;
import java.util.Objects;

public class Standorterfassung {
    private final Date datumUhrzeit;
    private final Standort standort;

    public Standorterfassung(Date datumUhrzeit, Standort standort) {
        this.datumUhrzeit = Objects.requireNonNull(datumUhrzeit);
        this.standort = Objects.requireNonNull(standort);
    }
}
