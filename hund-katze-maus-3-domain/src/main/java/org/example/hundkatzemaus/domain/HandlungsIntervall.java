package org.example.hundkatzemaus.domain;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HandlungsIntervall {
    private final Set<LocalTime> uhrzeiten;
    private final int tageDazwischen;

    public HandlungsIntervall(int tageDazwischen) {
        if (tageDazwischen < 1) {
            throw new IllegalArgumentException("Tage dazwischen muss mindestens 1 sein");
        }
        this.uhrzeiten = new HashSet<>();
        this.tageDazwischen = tageDazwischen;
    }

    public void zurUhrzeit(LocalTime uhrzeit) {
        uhrzeiten.add(Objects.requireNonNull(uhrzeit));
    }

    public Set<LocalTime> getUhrzeiten() {
        return uhrzeiten;
    }

    public int getTageDazwichen() {
        return tageDazwischen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlungsIntervall that = (HandlungsIntervall) o;
        return tageDazwischen == that.tageDazwischen && Objects.equals(uhrzeiten, that.uhrzeiten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uhrzeiten, tageDazwischen);
    }
}
