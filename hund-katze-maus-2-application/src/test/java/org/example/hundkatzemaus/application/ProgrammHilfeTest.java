package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.adapters.SystemKonsole;

import java.io.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgrammHilfeTest {
    private static final PrintStream systemAusgabe = System.out;
    private final ByteArrayOutputStream abgefangeneKonsolenAusgabe = new ByteArrayOutputStream();

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

        ProgrammHilfe.INSTANCE.ausführen(new String[]{}, new SystemKonsole());
        Optional<String> geleseneErsteZeile = abgefangeneKonsolenAusgabe.toString().lines().findFirst();

        assertTrue(geleseneErsteZeile.isPresent());
        assertEquals(ersteZeile, geleseneErsteZeile.get());
    }

    @org.junit.jupiter.api.Test
    void zeilenAnzahl() {
        long zeilenAnzahl = 8;

        ProgrammHilfe.INSTANCE.ausführen(new String[]{}, new SystemKonsole());

        assertEquals(zeilenAnzahl, abgefangeneKonsolenAusgabe.toString().lines().count());
    }
}