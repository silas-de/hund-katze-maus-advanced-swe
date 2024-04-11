package org.example.hundkatzemaus.domain;

public enum TierartAttribut {
    EXOTISCH("exotisch"), HEIMISCH("heimisch"), WILD("wild");

    private final String name;

    TierartAttribut(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
