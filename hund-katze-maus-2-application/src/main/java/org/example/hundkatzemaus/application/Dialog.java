package org.example.hundkatzemaus.application;

import java.io.BufferedReader;
import java.io.IOException;

public class Dialog {
    public static class EingabeException extends Exception {
        public EingabeException(String message) {
            super(message);
        }
    }

    public static boolean jaNeinFrageStellen(String frage, BufferedReader reader) throws EingabeException, IOException {
        System.out.print(frage + " [j/n]: ");
        String antwort = reader.readLine();
        if ("j".equals(antwort) || "J".equals(antwort)) {
            return true;
        } else if ("n".equals(antwort) || "N".equals(antwort)) {
            return false;
        } else {
            throw new EingabeException("Bitte antworten Sie mit j, J, n oder N.");
        }
    }

    public static String textFrageStellen(String frage, boolean darfLeerSein, BufferedReader reader) throws EingabeException, IOException {
        System.out.print(frage + " ");
        String antwort = reader.readLine();
        if (darfLeerSein || !antwort.isEmpty()) {
            return antwort;
        } else {
            throw new EingabeException("Bitte geben Sie eine Antwort ein.");
        }
    }

    public static int nichtnegativeGanzzahlErfragen(String frage, BufferedReader reader) throws EingabeException, IOException {
        System.out.print(frage + " ");
        try {
            int zahl = Integer.parseInt(reader.readLine());
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
