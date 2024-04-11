package org.example.hundkatzemaus.domain;

import org.example.abstraction.Icd10Code;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class Krankheit {
    private final Date datumUhrzeitFeststellung;
    private Date datumUhrzeitErkrankt;
    private Date datumUhrzeitGenesen;
    private Icd10Code icd10Code;
    private String beschreibung;

    public Krankheit(Date datumUhrzeitFeststellung, String beschreibung) {
        this.datumUhrzeitFeststellung = Objects.requireNonNull(datumUhrzeitFeststellung);
        aktualisiereBeschreibung(beschreibung);
    }

    public void erkranktAm(Date datumUhrzeitErkrankt) {
        this.datumUhrzeitErkrankt = Objects.requireNonNull(datumUhrzeitErkrankt);
    }

    public void genesenAm(Date datumUhrzeitGenesen) {
        this.datumUhrzeitGenesen = Objects.requireNonNull(datumUhrzeitGenesen);
    }

    public void hatICD10Code(Icd10Code icd10Code) {
        this.icd10Code = Objects.requireNonNull(icd10Code);
    }

    public void aktualisiereBeschreibung(String beschreibung) {
        this.beschreibung = Objects.requireNonNull(beschreibung);
    }

    public Date getDatumUhrzeitFeststellung() {
        return datumUhrzeitFeststellung;
    }

    public Optional<Date> getDatumUhrzeitErkrankt() {
        return Optional.ofNullable(datumUhrzeitErkrankt);
    }

    public Optional<Date> getDatumUhrzeitGenesen() {
        return Optional.ofNullable(datumUhrzeitGenesen);
    }

    public Optional<Icd10Code> getIcd10Code() {
        return Optional.ofNullable(icd10Code);
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}
