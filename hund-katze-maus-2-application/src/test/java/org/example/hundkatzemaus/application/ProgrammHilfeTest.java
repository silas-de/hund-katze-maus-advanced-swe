package org.example.hundkatzemaus.application;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgrammHilfeTest {
    private final ByteArrayOutputStream abgefangeneKonsolenAusgabe = new ByteArrayOutputStream();
    private static final PrintStream systemAusgabe = System.out;

    @org.junit.jupiter.api.BeforeEach
    public void konsolenAusgabeEinrichten() {
        System.setOut(new PrintStream(abgefangeneKonsolenAusgabe));
    }

    @org.junit.jupiter.api.AfterEach
    public void konsolenAusgabeZurücksetzen() {
        System.setOut(systemAusgabe);
    }

    @org.junit.jupiter.api.Test
    void ersteZeile() {
        String ersteZeile = "Benutzung:";

        ProgrammHilfe.instance.ausführen(new String[]{});
        Optional<String> geleseneErsteZeile = abgefangeneKonsolenAusgabe.toString().lines().findFirst();

        assertTrue(geleseneErsteZeile.isPresent());
        assertEquals(ersteZeile, geleseneErsteZeile.get());
    }

    @org.junit.jupiter.api.Test
    void zeilenAnzahl() {
        long zeilenAnzahl = 8;

        ProgrammHilfe.instance.ausführen(new String[]{});

        assertEquals(zeilenAnzahl, abgefangeneKonsolenAusgabe.toString().lines().count());
    }
}