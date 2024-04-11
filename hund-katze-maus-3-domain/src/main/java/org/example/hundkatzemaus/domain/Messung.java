package org.example.hundkatzemaus.domain;

import org.example.abstraction.Gewicht;
import org.example.abstraction.MillimeterMaße;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public record Messung(UUID id, Gewicht gewicht, MillimeterMaße millimeterMaße, Date datum) {
    public Messung {
        Objects.requireNonNull(id);
        Objects.requireNonNull(gewicht);
        Objects.requireNonNull(millimeterMaße);
        Objects.requireNonNull(datum);
        if (gewicht.inMilligramm() <= 0) {
            throw new IllegalArgumentException("Das Gewicht einer Messung darf nicht negativ sein.");
        }

    }

    public Messung(Gewicht gewicht, MillimeterMaße millimeterMaße, Date datum) {
        this(UUID.randomUUID(), gewicht, millimeterMaße, datum);
    }
}
