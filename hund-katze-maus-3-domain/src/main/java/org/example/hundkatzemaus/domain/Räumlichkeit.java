package org.example.hundkatzemaus.domain;

import org.example.abstraction.Gewicht;

import java.util.HashSet;
import java.util.Set;

public class Räumlichkeit extends Standort {
    private final Kennzeichnung kennzeichnung;
    private final Set<Tierart> tierarten;
    private final Gewicht kapazitätGewicht;
    private final int kapazitätAnzahl;

    public Räumlichkeit(Kennzeichnung kennzeichnung, Gewicht kapazitätGewicht, int kapazitätAnzahl) {
        this.kennzeichnung = kennzeichnung;
        this.tierarten = new HashSet<>();
        this.kapazitätGewicht = kapazitätGewicht;
        this.kapazitätAnzahl = kapazitätAnzahl;
    }

    public void fürTierart(Tierart tierart) {
        if (tierart == null) {
            throw new IllegalArgumentException("Tierart darf nicht null sein");
        }
        tierarten.add(tierart);
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
