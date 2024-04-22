package org.example.hundkatzemaus.application;

import java.io.IOException;

public class Dialog {
    public static class EingabeException extends Exception {
        public EingabeException(String message) {
            super(message);
        }
    }

    public static boolean jaNeinFrageStellen(String frage, Konsole konsole) throws EingabeException, IOException {
        konsole.ausgeben(frage + " [j/n]: ");
        String antwort = konsole.einlesen();
        if ("j".equals(antwort) || "J".equals(antwort)) {
            return true;
        } else if ("n".equals(antwort) || "N".equals(antwort)) {
            return false;
        } else {
            throw new EingabeException("Bitte antworten Sie mit j, J, n oder N.");
        }
    }

    public static String textFrageStellen(String frage, boolean darfLeerSein, Konsole konsole) throws EingabeException, IOException {
        konsole.ausgeben(frage + " ");
        String antwort = konsole.einlesen();
        if (darfLeerSein || !antwort.isEmpty()) {
            return antwort;
        } else {
            throw new EingabeException("Bitte geben Sie eine Antwort ein.");
        }
    }

    public static int nichtnegativeGanzzahlErfragen(String frage, Konsole konsole) throws EingabeException, IOException {
        konsole.ausgeben(frage + " ");
        try {
            int zahl = Integer.parseInt(konsole.einlesen());
            if (zahl >= 0) {
                return zahl;
            } else {
                throw new EingabeException("Bitte geben Sie eine positive Ganzzahl ein.");
            }
        } catch (NumberFormatException e) {
            throw new EingabeException("Bitte geben Sie eine positive Ganzzahl ein.");
        }
    }
}
