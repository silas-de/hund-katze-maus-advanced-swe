package org.example.abstraction;

import static org.junit.jupiter.api.Assertions.*;

class GewichtTest {
    @org.junit.jupiter.api.Test
    void nullGramm() {
        long keinGewicht = 0;

        Gewicht gewicht = new Gewicht(keinGewicht);
        Gewicht milliGramm = Gewicht.milligramm(keinGewicht);
        Gewicht gramm = Gewicht.gramm(keinGewicht);
        Gewicht kilogramm = Gewicht.kilogramm(keinGewicht);
        Gewicht tonnen = Gewicht.tonnen(keinGewicht);

        assertEquals(0, gewicht.inMilligramm());
        assertEquals(0, milliGramm.inMilligramm());
        assertEquals(0, gramm.inMilligramm());
        assertEquals(0, kilogramm.inMilligramm());
        assertEquals(0, tonnen.inMilligramm());
    }

    @org.junit.jupiter.api.Test
    void negativeGramm() {
        long negativesGewicht = -1;

        assertThrows(IllegalArgumentException.class, () -> new Gewicht(negativesGewicht));
        assertThrows(IllegalArgumentException.class, () -> Gewicht.milligramm(negativesGewicht));
        assertThrows(IllegalArgumentException.class, () -> Gewicht.gramm(negativesGewicht));
        assertThrows(IllegalArgumentException.class, () -> Gewicht.kilogramm(negativesGewicht));
        assertThrows(IllegalArgumentException.class, () -> Gewicht.tonnen(negativesGewicht));
    }

    @org.junit.jupiter.api.Test
    void einheitenUmformung() {
        long tonnen = 589 * 1_000_000_000L;
        long kilogramm = 823 * 1_000_000L;
        long gramm = 690 * 1_000L;
        long milligramm = 717;
        long gesamtMilligramm = tonnen + kilogramm + gramm + milligramm;

        Gewicht gewicht = new Gewicht(gesamtMilligramm);

        assertEquals(589, gewicht.inTonnen());
        assertEquals(589_823, gewicht.inKilogramm());
        assertEquals(589_823_690, gewicht.inGramm());
        assertEquals(589_823_690_717L, gewicht.inMilligramm());
    }

    @org.junit.jupiter.api.Test
    void gleichheit() {
        Gewicht gewicht1 = new Gewicht(1_234_000);
        Gewicht gewicht2 = new Gewicht(1_234_000);
        Gewicht gewicht3 = Gewicht.milligramm(1_234_000);
        Gewicht gewicht4 = Gewicht.gramm(1_234);
        Gewicht gewicht5 = Gewicht.kilogramm(1);
        Gewicht gewicht6 = Gewicht.milligramm(1_234_001);

        assertEquals(gewicht1, gewicht2);
        assertEquals(gewicht1, gewicht3);
        assertEquals(gewicht1, gewicht4);
        assertNotEquals(gewicht1, gewicht5);
        assertNotEquals(gewicht1, gewicht6);
    }
}