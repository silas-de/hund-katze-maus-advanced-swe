package org.example.hundkatzemaus.domain;

import java.util.Objects;

public enum StatusHerkunft {
    FUNDTIER("Fundtier"), ABGABETIER("Abgabetier");

    private final String name;

    StatusHerkunft(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }
}
