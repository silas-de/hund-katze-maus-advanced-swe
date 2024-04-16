package org.example.hundkatzemaus.domain;

import java.time.LocalDate;
import java.util.Objects;

public record Abgabevertrag(Besitzer alterBesitzer, Besitzer neuerBesitzer, LocalDate abgabeDatum) {
    public Abgabevertrag {
        Objects.requireNonNull(alterBesitzer);
        Objects.requireNonNull(neuerBesitzer);
        Objects.requireNonNull(abgabeDatum);
    }

    public String beschreibung() {
        return "von " + alterBesitzer + " an " + neuerBesitzer + " am " + abgabeDatum;
    }
}
