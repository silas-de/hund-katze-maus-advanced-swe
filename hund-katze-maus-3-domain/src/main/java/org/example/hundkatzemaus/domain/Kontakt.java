package org.example.hundkatzemaus.domain;

import org.example.abstraction.Adresse;
import org.example.abstraction.EmailAdresse;
import org.example.abstraction.Namen;
import org.example.abstraction.Telefonnummer;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Kontakt implements Besitzer {
    private final UUID id;
    private Namen namen;
    private Adresse adresse;
    private EmailAdresse emailAdresse;
    private Telefonnummer telefonnummer;

    public Kontakt(UUID id, Namen namen, Adresse adresse, EmailAdresse emailAdresse, Telefonnummer telefonnummer) {
        this.id = id;
        this.namen = Objects.requireNonNull(namen);
        this.adresse = Objects.requireNonNull(adresse);
        this.emailAdresse = emailAdresse;
        this.telefonnummer = telefonnummer;
    }

    public Kontakt(Namen namen, Adresse adresse, EmailAdresse emailAdresse, Telefonnummer telefonnummer) {
        this(UUID.randomUUID(), namen, adresse, emailAdresse, telefonnummer);
    }

    public Optional<EmailAdresse> emailAdresse() {
        return Optional.ofNullable(emailAdresse);
    }

    public Optional<Telefonnummer> telefonnummer() {
        return Optional.ofNullable(telefonnummer);
    }

    @Override
    public String listenEintrag() {
        return namen.vorname() + " " + namen.nachname() + ", " + adresse.ort();
    }
}
