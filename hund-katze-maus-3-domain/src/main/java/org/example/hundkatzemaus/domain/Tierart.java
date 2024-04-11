package org.example.hundkatzemaus.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Tierart {
    private final UUID id;
    private final String name;
    private final Set<TierartAttribut> attribute;
    private final Set<String> futter;
    private final HandlungsIntervall fütterungsIntervall;
    private final HandlungsIntervall untersuchungsIntervall;
    private final Set<String> besonderheiten;
    private final Tierart oberArt;
    private final Set<Tierart> unterArten;

    public Tierart(UUID id, String name, HandlungsIntervall fütterungsIntervall, HandlungsIntervall untersuchungsIntervall,
                   Tierart oberArt) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(fütterungsIntervall);
        Objects.requireNonNull(untersuchungsIntervall);

        this.id = id;
        this.name = name;
        this.attribute = new HashSet<>();
        this.futter = new HashSet<>();
        this.fütterungsIntervall = fütterungsIntervall;
        this.untersuchungsIntervall = untersuchungsIntervall;
        this.besonderheiten = new HashSet<>();
        this.oberArt = oberArt;
        this.unterArten = new HashSet<>();

        if (oberArt != null)
            this.oberArt.unterartZuordnen(this);
    }

    private void unterartZuordnen(Tierart unterArt) {
        if (unterArt == null) {
            throw new IllegalArgumentException("Unterart darf nicht null sein");
        }
        unterArten.add(unterArt);
    }

    public void mitAttribut(TierartAttribut attribut) {
        if (attribut == null) {
            throw new IllegalArgumentException("Attribut darf nicht null sein");
        }
        attribute.add(attribut);
    }

    public void mitFutter(String futter) {
        if (futter == null) {
            throw new IllegalArgumentException("Futter darf nicht null sein");
        }
        this.futter.add(futter);
    }

    public void mitBesonderheit(String besonderheit) {
        if (besonderheit == null) {
            throw new IllegalArgumentException("Besonderheit darf nicht null sein");
        }
        besonderheiten.add(besonderheit);
    }

    public boolean gehörtZuOberart(Tierart tierart) {
        if (tierart == null) {
            return false;
        }
        return this.equals(tierart) || gehörtZuOberart(tierart.oberArt);
    }
}
