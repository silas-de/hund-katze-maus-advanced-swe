package org.example.hundkatzemaus.domain;

public enum StatusHerkunft {
    FUNDTIER("Fundtier"), ABGABETIER("Abgabetier");

    private final String name;

    StatusHerkunft(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
