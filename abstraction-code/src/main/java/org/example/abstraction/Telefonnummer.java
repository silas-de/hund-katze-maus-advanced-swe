package org.example.abstraction;

import java.util.Objects;

public record Telefonnummer(String nummer) {
    public Telefonnummer {
        if (Objects.requireNonNull(nummer).isBlank()) {
            throw new IllegalArgumentException("Telefonnummer darf nicht leer sein");
        }
    }
}
