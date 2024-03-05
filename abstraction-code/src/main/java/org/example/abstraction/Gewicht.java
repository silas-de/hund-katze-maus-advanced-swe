package org.example.abstraction;

public record Gewicht(long milligramm) {
    public Gewicht {
        if (milligramm < 0) {
            throw new IllegalArgumentException("Gewicht darf nicht negativ sein.");
        }
    }

    public static Gewicht milligramm(long milligramm) {
        return new Gewicht(milligramm);
    }

    public static Gewicht gramm(long gramm) {
        return new Gewicht(Math.multiplyExact(gramm, 1_000));
    }

    public static Gewicht kilogramm(long kilogramm) {
        return new Gewicht(Math.multiplyExact(kilogramm, 1_000_000));
    }

    public static Gewicht tonnen(long tonnen) {
        return new Gewicht(Math.multiplyExact(tonnen, 1_000_000_000));
    }

    public long toMilligramm() {
        return milligramm;
    }

    public long toGramm() {
        return milligramm / 1_000;
    }

    public long toKilogramm() {
        return milligramm / 1_000_000;
    }

    public long toTonnen() {
        return milligramm / 1_000_000_000;
    }
}
