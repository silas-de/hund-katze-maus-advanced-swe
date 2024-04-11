package org.example.hundkatzemaus.domain;

import java.util.UUID;

public abstract class Standort {
    private final UUID id;

    protected Standort(UUID id) {
        this.id = id;
    }
}
