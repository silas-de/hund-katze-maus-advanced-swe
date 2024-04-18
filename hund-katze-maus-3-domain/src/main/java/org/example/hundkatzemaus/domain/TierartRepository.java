package org.example.hundkatzemaus.domain;

import java.util.Optional;
import java.util.UUID;

public interface TierartRepository {
    Optional<Tierart> finde(UUID id);

    void registriere(Tierart tierart);
}
