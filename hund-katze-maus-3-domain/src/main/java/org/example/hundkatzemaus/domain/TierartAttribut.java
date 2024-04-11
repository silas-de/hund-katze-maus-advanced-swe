package org.example.hundkatzemaus.domain;

import java.util.Objects;

public enum TierartAttribut {
    EXOTISCH("exotisch"), HEIMISCH("heimisch"), WILD("wild");

    private final String name;

    TierartAttribut(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }
}
