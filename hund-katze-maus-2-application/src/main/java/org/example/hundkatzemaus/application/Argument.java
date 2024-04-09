package org.example.hundkatzemaus.application;

/**
 * Argumente sind die Bestandteile einer Eingabe, die von der Anwendung verarbeitet werden.
 * Sie sind durch Leerzeichen getrennt.
 */
interface Argument {
    boolean entsprichtEingabe(String eingabe);
    String getDokumentation();
}

