package org.example.hundkatzemaus.domain;

import java.util.Objects;
import java.util.UUID;

public class KonkretesTier implements Tier {
    private final UUID id;
    private Tierart tierart;

    public KonkretesTier(UUID id, Tierart tierart) {
        this.id = Objects.requireNonNull(id);
        this.tierart = Objects.requireNonNull(tierart);
    }

    public static Tier aufnehmen(Tierart tierart) {
        return new KonkretesTier(UUID.randomUUID(), tierart);
    }

    public Tierart getTierart() {
        return tierart;
    }

    @Override
    public Besitzer getBesitzer() {
        return BesitzerNiemand.NIEMAND;
    }

    @Override
    public String fluktuation() {
        return "Ende.";
    }
}
