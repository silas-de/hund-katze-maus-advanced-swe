package org.example.hundkatzemaus.domain;

import java.util.Date;
import java.util.Objects;

public record Standorterfassung(Date datumUhrzeit, Standort standort) {
    public Standorterfassung {
        Objects.requireNonNull(datumUhrzeit);
        Objects.requireNonNull(standort);
    }
}
