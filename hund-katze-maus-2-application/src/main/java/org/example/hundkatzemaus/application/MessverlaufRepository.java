package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.domain.Messverlauf;
import org.example.hundkatzemaus.domain.Tier;

import java.util.Optional;

public class MessverlaufRepository implements org.example.hundkatzemaus.domain.MessverlaufRepository {
    @Override
    public Optional<Messverlauf> findeVon(Tier tier) {
        return Optional.empty();
    }

    @Override
    public Messverlauf registriere(Tier tier) {
        return null;
    }

    @Override
    public void speichere(Messverlauf messverlauf) {

    }
}
