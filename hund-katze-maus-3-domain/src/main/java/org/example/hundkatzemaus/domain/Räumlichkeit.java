package org.example.hundkatzemaus.domain;

import org.example.abstraction.Gewicht;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Räumlichkeit extends Standort {
    private final Kennzeichnung kennzeichnung;
    private final Set<Tierart> tierarten;
    private final Gewicht kapazitätGewicht;
    private final int kapazitätAnzahl;

    public Räumlichkeit(UUID id, Kennzeichnung kennzeichnung, Gewicht kapazitätGewicht, int kapazitätAnzahl) {
        super(id);
        this.kennzeichnung = Objects.requireNonNull(kennzeichnung);
        this.tierarten = new HashSet<>();
        this.kapazitätGewicht = Objects.requireNonNull(kapazitätGewicht);
        this.kapazitätAnzahl = kapazitätAnzahl;
    }

    public void fürTierart(Tierart tierart) {
        tierarten.add(Objects.requireNonNull(tierart));
    }

    public boolean istFürTierart(Tierart tierart) {
        return tierarten.stream().anyMatch(tierart::gehörtZuOberart);
    }

    public enum Kennzeichnung {
        QUARANTÄNE_STATION("Quarantänestation"), KRANKE_STATION("Krankenstation"),
        NORMAL_UNTERKUNFT("Normale Unterkunft"), AUSLAUF_FLÄCHE("Auslauffläche"),
        STATION_FÜR_PENSIONSTIERE("Station für Pensionstiere"), RUHEZONE("Ruhezone");

        private String name;

        private Kennzeichnung(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
