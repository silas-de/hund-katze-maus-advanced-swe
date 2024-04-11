package org.example.abstraction;

public record Adresse(String straße, String hausnummer, String plz, String ort) {
    public Adresse {
        if (straße == null || straße.isBlank()) {
            throw new IllegalArgumentException("Straße darf nicht leer sein");
        }
        if (hausnummer == null || hausnummer.isBlank()) {
            throw new IllegalArgumentException("Hausnummer darf nicht leer sein");
        }
        if (plz == null || plz.isBlank()) {
            throw new IllegalArgumentException("PLZ darf nicht leer sein");
        }
        if (ort == null || ort.isBlank()) {
            throw new IllegalArgumentException("Ort darf nicht leer sein");
        }
    }
}