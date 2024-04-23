package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.domain.Tier;
import org.example.hundkatzemaus.domain.Tierart;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProgrammTiereÜbersichtTest {

    @org.junit.jupiter.api.Test
    void keineTiere() throws IOException {
        // Arrange
        String zeile0TiereInsgesamt = "Insgesamt 0 Tiere" + System.lineSeparator();
        String zeile0TiereNeu = "Neu aufgenommen in den letzten 7 Tagen: 0 Tiere" + System.lineSeparator();

        try (Konsole konsole = mock(Konsole.class)) {
            // Act
            TierRepository tierRepository = mock(TierRepository.class);
            when(tierRepository.anzahlTiere()).thenReturn(0L);
            when(tierRepository.aufgenommenInDenLetztenTagen(7)).thenReturn(List.of());
            new ProgrammTiereÜbersicht(tierRepository).ausführen(new String[]{}, konsole);
            // Assert
            Mockito.verify(konsole).ausgeben(zeile0TiereInsgesamt);
            Mockito.verify(konsole).ausgeben(zeile0TiereNeu);
        }
    }

    @org.junit.jupiter.api.Test
    void tiere2Hunde1Katze() throws IOException {
        // Arrange
        String zeile0TiereInsgesamt = "Insgesamt 3 Tiere" + System.lineSeparator();
        String zeile0TiereNeu = "Neu aufgenommen in den letzten 7 Tagen: 3 Tiere" + System.lineSeparator();
        String zeile1Hund = "- 2x Hund" + System.lineSeparator();
        String zeile2Katze = "- 1x Katze" + System.lineSeparator();
        Tierart hund = mock(Tierart.class);
        when(hund.getName()).thenReturn("Hund");
        Tierart katze = mock(Tierart.class);
        when(katze.getName()).thenReturn("Katze");
        Tier hund1 = mock(Tier.class);
        when(hund1.getTierart()).thenReturn(hund);
        Tier hund2 = mock(Tier.class);
        when(hund2.getTierart()).thenReturn(hund);
        Tier katze1 = mock(Tier.class);
        when(katze1.getTierart()).thenReturn(katze);

        try (Konsole konsole = mock(Konsole.class)) {
            // Act
            TierRepository tierRepository = mock(TierRepository.class);
            when(tierRepository.anzahlTiere()).thenReturn(3L);
            when(tierRepository.aufgenommenInDenLetztenTagen(7)).thenReturn(List.of(
                    hund1, hund2, katze1
            ));
            ProgrammTiereÜbersicht programm = new ProgrammTiereÜbersicht(tierRepository);
            programm.ausführen(new String[]{}, konsole);

            // Assert
            Mockito.verify(konsole).ausgeben(zeile0TiereInsgesamt);
            Mockito.verify(konsole).ausgeben(zeile0TiereNeu);
            Mockito.verify(konsole).ausgeben(zeile1Hund);
            Mockito.verify(konsole).ausgeben(zeile2Katze);
        }
    }
}
