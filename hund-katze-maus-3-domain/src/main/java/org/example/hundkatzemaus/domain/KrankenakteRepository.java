package org.example.hundkatzemaus.domain;

import java.util.Optional;
import java.util.UUID;

public interface KrankenakteRepository {
    void speichere(Krankenakte krankenakte);
    Optional<Krankenakte> findeFür(Tier tier);
}
