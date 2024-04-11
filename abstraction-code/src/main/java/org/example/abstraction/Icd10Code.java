package org.example.abstraction;

import java.util.Objects;

public record Icd10Code(String code) {
    private static final String ICD_10_FORMAT = "[A-TV-Z][0-9]{2}";
    public Icd10Code {
        if (Objects.requireNonNull(code).isBlank()) {
            throw new IllegalArgumentException("code darf nicht null oder leer sein");
        }
        if (!code.matches(ICD_10_FORMAT)) {
            throw new IllegalArgumentException("code entspricht nicht dem ICD-10-Format");
        }
    }
}
