package org.example.hundkatzemaus.domain;

import java.util.Objects;
import java.util.UUID;

public record Tierart(UUID id, Tierart oberart, String name) {
    public Tierart {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
    }

    public Tierart(Tierart oberart, String name) {
        this(UUID.randomUUID(), oberart, name);
    }
}
