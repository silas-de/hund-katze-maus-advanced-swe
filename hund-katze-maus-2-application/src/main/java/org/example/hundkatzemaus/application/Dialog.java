package org.example.hundkatzemaus.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

public class Dialog {
    public static Optional<Boolean> jaNeinFrageStellen(String frage, BufferedReader reader) {
        try {
            System.out.print(frage + " [j/n]: ");
            String antwort = reader.readLine();
            if ("j".equals(antwort) || "J".equals(antwort)) {
                return Optional.of(true);
            } else if ("n".equals(antwort) || "N".equals(antwort)) {
                return Optional.of(false);
            } else {
                return Optional.of(false);
            }
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public static Optional<String> textFrageStellen(String frage, boolean darfLeerSein, BufferedReader reader) {
        System.out.print(frage + " ");
        try {
            String antwort = reader.readLine();
            if (darfLeerSein || !antwort.isEmpty()) {
                return Optional.of(antwort);
            } else {
                System.err.println("Bitte geben Sie eine Antwort ein.");
                return Optional.empty();
            }
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    /**
     * @return die Antwort auf die Frage, oder -1, wenn die Antwort eine negative Ganzzahl war
     */
    public static int nichtnegativeGanzzahlErfragen(String frage, BufferedReader reader) {
        System.out.print(frage + " ");
        try {
            int zahl = Integer.parseInt(reader.readLine());
            if (zahl >= 0) {
                return zahl;
            } else {
                System.err.println("Bitte geben Sie eine positive Ganzzahl ein.");
                return -1;
            }
        } catch (NumberFormatException | IOException e) {
            System.err.println("Bitte geben Sie eine positive Ganzzahl ein.");
            return -1;
        }
    }
}
