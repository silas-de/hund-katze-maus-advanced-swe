package org.example.abstraction;

public record Telefonnummer(String nummer) {
    public Telefonnummer {
        if (nummer == null || nummer.isBlank()) {
            throw new IllegalArgumentException("Telefonnummer darf nicht leer sein");
        }
    }
}
