package org.example.hundkatzemaus.domain;

import org.example.abstraction.Gewicht;
import org.example.abstraction.MillimeterMaße;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public record Messung(UUID id, Tier tier, Gewicht gewicht, MillimeterMaße millimeterMaße, Date datum) {
    public Messung {
        Objects.requireNonNull(tier, "Das Tier, das gemessen wird, darf nicht null sein.");
        Objects.requireNonNull(gewicht, "Das Gewicht einer Messung darf nicht null sein.");
        Objects.requireNonNull(millimeterMaße, "Die Maße einer Messung darf nicht null sein.");
        Objects.requireNonNull(datum, "Das Datum einer Messung darf nicht null sein.");
        if (gewicht.inMilligramm() <= 0) {
            throw new IllegalArgumentException("Das Gewicht einer Messung darf nicht negativ sein.");
        }
    }

    public Messung(Tier tier, Gewicht gewicht, MillimeterMaße millimeterMaße, Date datum) {
        this(UUID.randomUUID(), tier, gewicht, millimeterMaße, datum);
    }
}
