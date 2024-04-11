package org.example.hundkatzemaus.domain;

import org.example.abstraction.Icd10Code;

import java.util.Date;
import java.util.Optional;

public class Krankheit {
    private final Date datumUhrzeitFeststellung;
    private Date datumUhrzeitErkrankt;
    private Date datumUhrzeitGenesen;
    private Icd10Code icd10Code;
    private String beschreibung;

    public Krankheit(Date datumUhrzeitFeststellung, String beschreibung) {
        if (datumUhrzeitFeststellung == null) {
            throw new IllegalArgumentException("datumUhrzeitFeststellung darf nicht null sein");
        }
        this.datumUhrzeitFeststellung = datumUhrzeitFeststellung;
        aktualisiereBeschreibung(beschreibung);
    }

    public void erkranktAm(Date datumUhrzeitErkrankt) {
        if (datumUhrzeitErkrankt == null) {
            throw new IllegalArgumentException("datumUhrzeitErkrankt darf nicht null sein");
        }
        this.datumUhrzeitErkrankt = datumUhrzeitErkrankt;
    }

    public void genesenAm(Date datumUhrzeitGenesen) {
        if (datumUhrzeitGenesen == null) {
            throw new IllegalArgumentException("datumUhrzeitGenesen darf nicht null sein");
        }
        this.datumUhrzeitGenesen = datumUhrzeitGenesen;
    }

    public void hatICD10Code(Icd10Code icd10Code) {
        if (icd10Code == null) {
            throw new IllegalArgumentException("icd10Code darf nicht null sein");
        }
        this.icd10Code = icd10Code;
    }

    public void aktualisiereBeschreibung(String beschreibung) {
        if (beschreibung == null) {
            throw new IllegalArgumentException("beschreibung darf nicht null sein");
        }
        this.beschreibung = beschreibung;
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
