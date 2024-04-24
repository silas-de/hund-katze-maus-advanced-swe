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
        ausgabeCaptor = ArgumentCaptor.forClass(String.class);

        // Act
        int gemesseneZeilenAnzahl;
        try (Konsole konsole = Mockito.mock(Konsole.class)) {
            ProgrammHilfe.INSTANCE.ausführen(new String[]{}, konsole);
            Mockito.verify(konsole, Mockito.atLeastOnce()).ausgeben(ausgabeCaptor.capture());

            String ausgabe = String.join("", ausgabeCaptor.getAllValues());
            String[] einzelneZeilen = ausgabe.split(System.lineSeparator());
            gemesseneZeilenAnzahl = einzelneZeilen.length;
        }

        // Assert
        assertEquals(erwarteteZeilenAnzahl, gemesseneZeilenAnzahl);
    }
}
