package org.example.abstraction;

import java.util.Objects;

public record Adresse(String straße, String hausnummer, String plz, String ort) {
    public Adresse {
        if (Objects.requireNonNull(straße).isBlank()) {
            throw new IllegalArgumentException("Straße darf nicht leer sein");
        }
        if (Objects.requireNonNull(hausnummer).isBlank()) {
            throw new IllegalArgumentException("Hausnummer darf nicht leer sein");
        }
        if (Objects.requireNonNull(plz).isBlank()) {
            throw new IllegalArgumentException("PLZ darf nicht leer sein");
        }
        if (Objects.requireNonNull(ort).isBlank()) {
            throw new IllegalArgumentException("Ort darf nicht leer sein");
        }
    }
}