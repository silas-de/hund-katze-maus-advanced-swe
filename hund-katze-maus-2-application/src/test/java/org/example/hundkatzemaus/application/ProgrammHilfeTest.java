package org.example.hundkatzemaus.application;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgrammHilfeTest {
    @Captor
    private ArgumentCaptor<String> ausgabeCaptor;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ausgabeCaptor = null;
    }

    @org.junit.jupiter.api.Test
    void ersteZeile() throws IOException {
        // Arrange
        String erwarteteErsteZeile = "Benutzung:" + System.lineSeparator();

        try (Konsole konsole = Mockito.mock(Konsole.class)) {
            // Act
            ProgrammHilfe.INSTANCE.ausführen(new String[]{}, konsole);

            // Assert
            Mockito.verify(konsole).ausgeben(erwarteteErsteZeile);
        }
    }

    @org.junit.jupiter.api.Test
    void zeilenAnzahl() throws IOException {
        // Arrange
        int erwarteteZeilenAnzahl = 10;

        // Act
        int zeilenAnzahl;
        try (Konsole konsole = Mockito.mock(Konsole.class)) {
            ProgrammHilfe.INSTANCE.ausführen(new String[]{}, konsole);
            ausgabeCaptor = ArgumentCaptor.forClass(String.class);
            Mockito.verify(konsole, Mockito.atLeastOnce()).ausgeben(ausgabeCaptor.capture());

            String ausgabe = String.join("", ausgabeCaptor.getAllValues());
            String[] zeilen = ausgabe.split(System.lineSeparator());
            zeilenAnzahl = zeilen.length;
        }

        // Assert
        assertEquals(erwarteteZeilenAnzahl, zeilenAnzahl);
    }
}