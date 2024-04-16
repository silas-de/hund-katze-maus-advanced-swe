package org.example.hundkatzemaus.domain;

import java.util.Objects;

public abstract class TierDekorierer implements Tier {
    protected final Tier tierVorher;

    public TierDekorierer(Tier tierVorher) {
        this.tierVorher = Objects.requireNonNull(tierVorher);
    }

    public abstract String ereignisBeschreibung();

    @Override
    public Tierart getTierart() {
        return tierVorher.getTierart();
    }

    @Override
    public String fluktuation() {
        return ereignisBeschreibung() + " - " + tierVorher.fluktuation();
    }
}
