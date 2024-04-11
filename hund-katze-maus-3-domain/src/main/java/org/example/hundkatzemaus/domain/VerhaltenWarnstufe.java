package org.example.hundkatzemaus.domain;

public enum VerhaltenWarnstufe {
    NORMAL("Normal"), WARNUNG("Warnung"), KRITISCH("Kritisch");

    private final String name;

    VerhaltenWarnstufe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
