package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.domain.Tier;

import java.util.List;

public enum TierRepository implements org.example.hundkatzemaus.domain.TierRepository {
    INSTANCE;

    @Override
    public long anzahlTiere() {
        return 0;
    }

    @Override
    public List<Tier> aufgenommenInDenLetztenTagen(int tage) {
        return List.of();
    }

    @Override
    public List<Tier> fluktuationInDenLetztenTagen(int tage) {
        return List.of();
    }
}
