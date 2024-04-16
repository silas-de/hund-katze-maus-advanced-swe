package org.example.abstraction;

import java.util.Objects;

public record Namen(String vorname, String nachname) {
    public Namen {
        if (Objects.requireNonNull(vorname).isBlank()) {
            throw new IllegalArgumentException("Vorname darf nicht leer sein");
        }
        if (Objects.requireNonNull(nachname).isBlank()) {
            throw new IllegalArgumentException("Nachname darf nicht leer sein");
        }
    }
}
