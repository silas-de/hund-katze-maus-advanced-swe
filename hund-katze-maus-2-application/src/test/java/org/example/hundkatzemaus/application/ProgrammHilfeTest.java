package org.example.hundkatzemaus.application;

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

        ProgrammHilfe.INSTANCE.ausführen(new String[]{}, new Konsole() {
            private static final PrintStream ausgabe = System.out;
            private static final BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));

            public void ausgeben(String text) {
                ausgabe.println(text);
            }

            public String einlesen() throws IOException {
                return eingabe.readLine();
            }

            @Override
            public void close() throws IOException {
                eingabe.close();
            }
        });
        Optional<String> geleseneErsteZeile = abgefangeneKonsolenAusgabe.toString().lines().findFirst();

        assertTrue(geleseneErsteZeile.isPresent());
        assertEquals(ersteZeile, geleseneErsteZeile.get());
    }

    @org.junit.jupiter.api.Test
    void zeilenAnzahl() {
        long zeilenAnzahl = 8;

        ProgrammHilfe.INSTANCE.ausführen(new String[]{}, new Konsole() {
            private static final PrintStream ausgabe = System.out;
            private static final BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));

            public void ausgeben(String text) {
                ausgabe.println(text);
            }

            public String einlesen() throws IOException {
                return eingabe.readLine();
            }

            @Override
            public void close() throws IOException {
                eingabe.close();
            }
        });

        assertEquals(zeilenAnzahl, abgefangeneKonsolenAusgabe.toString().lines().count());
    }
}