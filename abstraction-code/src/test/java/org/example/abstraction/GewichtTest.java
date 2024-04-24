package org.example.abstraction;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class GewichtTest {
    @org.junit.jupiter.api.Test
    void nullGramm() {
        // Arrange
        long zahlNull = 0;

        // Act
        Gewicht gewicht = new Gewicht(zahlNull);
        Gewicht milliGramm = Gewicht.milligramm(zahlNull);
        Gewicht gramm = Gewicht.gramm(zahlNull);
        Gewicht kilogramm = Gewicht.kilogramm(zahlNull);
        Gewicht tonnen = Gewicht.tonnen(zahlNull);

        // Assert
        assertEquals(0, gewicht.inMilligramm());
        assertEquals(0, milliGramm.inMilligramm());
        assertEquals(0, gramm.inMilligramm());
        assertEquals(0, kilogramm.inMilligramm());
        assertEquals(0, tonnen.inMilligramm());
    }

    @org.junit.jupiter.api.Test
    void negativeGramm() {
        // Arrange
        long negativeZahl = -1;

        // Act
        Executable negativesGewichtErzeugen = () -> new Gewicht(negativeZahl);
        Executable negativeMilligrammErzeugen = () -> Gewicht.milligramm(negativeZahl);
        Executable negativeGrammErzeugen = () -> Gewicht.gramm(negativeZahl);
        Executable negativeKilogrammErzeugen = () -> Gewicht.kilogramm(negativeZahl);
        Executable negativeTonnenErzeugen = () -> Gewicht.tonnen(negativeZahl);

        // Assert
        assertThrows(IllegalArgumentException.class, negativesGewichtErzeugen);
        assertThrows(IllegalArgumentException.class, negativeMilligrammErzeugen);
        assertThrows(IllegalArgumentException.class, negativeGrammErzeugen);
        assertThrows(IllegalArgumentException.class, negativeKilogrammErzeugen);
        assertThrows(IllegalArgumentException.class, negativeTonnenErzeugen);
    }

    @org.junit.jupiter.api.Test
    void einheitenUmformung() {
        // Arrange
        long tonnenAnteil = 589 * 1_000_000_000L;
        long kilogrammAnteil = 823 * 1_000_000L;
        long grammAnteil = 690 * 1_000L;
        long milligrammAnteil = 717;
        long gesamtMilligrammWert = tonnenAnteil + kilogrammAnteil + grammAnteil + milligrammAnteil;

        // Act
        Gewicht gesamtGewicht = new Gewicht(gesamtMilligrammWert);

        // Assert
        assertEquals(589, gesamtGewicht.inTonnen());
        assertEquals(589_823, gesamtGewicht.inKilogramm());
        assertEquals(589_823_690, gesamtGewicht.inGramm());
        assertEquals(589_823_690_717L, gesamtGewicht.inMilligramm());
    }

    @org.junit.jupiter.api.Test
    void gleichheit() {
        // Arrange
        long milligrammWert = 1_234_000;
        long gleicherGrammWert = 1_234;
        long andererKilogrammWert = 1;
        long andererMilligrammWert = 1_234_001;

        // Act
        Gewicht originalGewicht = new Gewicht(milligrammWert);
        Gewicht auchGewicht1234000 = new Gewicht(milligrammWert);
        Gewicht gewicht1234000Millligramm = Gewicht.milligramm(milligrammWert);
        Gewicht gewicht1234Gramm = Gewicht.gramm(gleicherGrammWert);
        Gewicht anderesGewicht1Kilogramm = Gewicht.kilogramm(andererKilogrammWert);
        Gewicht anderesGewicht1234001Milligramm = Gewicht.milligramm(andererMilligrammWert);

        // Assert
        assertEquals(originalGewicht, auchGewicht1234000);
        assertEquals(originalGewicht, gewicht1234000Millligramm);
        assertEquals(originalGewicht, gewicht1234Gramm);
        assertNotEquals(originalGewicht, anderesGewicht1Kilogramm);
        assertNotEquals(originalGewicht, anderesGewicht1234001Milligramm);
    }
}
