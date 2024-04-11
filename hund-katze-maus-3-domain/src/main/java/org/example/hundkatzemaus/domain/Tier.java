package org.example.hundkatzemaus.domain;

import java.util.Objects;
import java.util.UUID;

public class Tier {
    private final UUID id;
    private Tierart tierart;

    public Tier(UUID id, Tierart tierart) {
        this.id = Objects.requireNonNull(id);
        this.tierart = Objects.requireNonNull(tierart);
    }

    public static Tier aufnehmen(Tierart tierart) {
        return new Tier(UUID.randomUUID(), tierart);
    }
}
