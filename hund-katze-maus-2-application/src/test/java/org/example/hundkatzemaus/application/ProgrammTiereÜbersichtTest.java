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
        String erwarteteZeile0TiereInsgesamt = "Insgesamt 0 Tiere" + System.lineSeparator();
        String erwarteteZeile0TiereNeu = "Neu aufgenommen in den letzten 7 Tagen: 0 Tiere" + System.lineSeparator();
        long keineTiere = 0L;
        int letzte7Tage = 7;
        TierRepository tierRepository = mock(TierRepository.class);
        when(tierRepository.anzahlTiere()).thenReturn(keineTiere);
        when(tierRepository.aufgenommenInDenLetztenTagen(letzte7Tage)).thenReturn(List.of());
        ProgrammTiereÜbersicht programm = new ProgrammTiereÜbersicht(tierRepository);

        try (Konsole konsole = mock(Konsole.class)) {
            // Act
            programm.ausführen(new String[]{}, konsole);

            // Assert
            Mockito.verify(konsole).ausgeben(erwarteteZeile0TiereInsgesamt);
            Mockito.verify(konsole).ausgeben(erwarteteZeile0TiereNeu);
        }
    }

    @org.junit.jupiter.api.Test
    void tiere2Hunde1Katze() throws IOException {
        // Arrange
        String erwarteteZeile0TiereInsgesamt = "Insgesamt 3 Tiere" + System.lineSeparator();
        String erwarteteZeile0TiereNeu = "Neu aufgenommen in den letzten 7 Tagen: 3 Tiere" + System.lineSeparator();
        String erwarteteZeile1Hund = "- 2x Hund" + System.lineSeparator();
        String erwarteteZeile2Katze = "- 1x Katze" + System.lineSeparator();
        List<Tier> tiere = mock3Tiere2Hunde1Katze();
        TierRepository tierRepository = mock(TierRepository.class);
        when(tierRepository.anzahlTiere()).thenReturn(3L);
        when(tierRepository.aufgenommenInDenLetztenTagen(7)).thenReturn(tiere);
        ProgrammTiereÜbersicht programm = new ProgrammTiereÜbersicht(tierRepository);

        try (Konsole konsole = mock(Konsole.class)) {
            // Act
            programm.ausführen(new String[]{}, konsole);

            // Assert
            Mockito.verify(konsole).ausgeben(erwarteteZeile0TiereInsgesamt);
            Mockito.verify(konsole).ausgeben(erwarteteZeile0TiereNeu);
            Mockito.verify(konsole).ausgeben(erwarteteZeile1Hund);
            Mockito.verify(konsole).ausgeben(erwarteteZeile2Katze);
        }
    }

    private static List<Tier> mock3Tiere2Hunde1Katze() {
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
        return List.of(hund1, katze1, hund2);
    }
}
