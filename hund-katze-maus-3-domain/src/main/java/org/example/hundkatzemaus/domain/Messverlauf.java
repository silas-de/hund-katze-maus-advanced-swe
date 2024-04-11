package org.example.hundkatzemaus.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Messverlauf {
    private final UUID id, tierId;
    private final List<Messung> messungen;

    public Messverlauf(UUID id, UUID tierId) {
        this.id = id;
        this.tierId = tierId;
        this.messungen = new ArrayList<>();
    }
}
