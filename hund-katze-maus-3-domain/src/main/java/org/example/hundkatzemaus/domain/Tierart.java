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
        unterArten.add(Objects.requireNonNull(unterArt));
    }

    public void mitAttribut(TierartAttribut attribut) {
        attribute.add(Objects.requireNonNull(attribut));
    }

    public void mitFutter(String futter) {
        this.futter.add(Objects.requireNonNull(futter));
    }

    public void mitBesonderheit(String besonderheit) {
        besonderheiten.add(Objects.requireNonNull(besonderheit));
    }

    public boolean gehörtZuOberart(Tierart tierart) {
        if (tierart == null) {
            return false;
        }
        return this.equals(tierart) || gehörtZuOberart(tierart.oberArt);
    }

    public String getName() {
        return name;
    }
}
