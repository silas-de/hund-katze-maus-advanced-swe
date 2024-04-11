package org.example.hundkatzemaus.domain;

import java.util.Optional;

public interface MessverlaufRepository {
    Optional<Messverlauf> findeVon(Tier tier);
    Messverlauf registriere(Tier tier);
    void speichere(Messverlauf messverlauf);
}
