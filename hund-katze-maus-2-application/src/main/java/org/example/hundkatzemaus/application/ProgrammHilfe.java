package org.example.hundkatzemaus.application;

public enum ProgrammHilfe implements Programm {
    INSTANCE;

    @Override
    public void ausführen(String[] args, Konsole konsole) {
        konsole.ausgeben("Benutzung:" + System.lineSeparator());
        for (Modus modus : Modus.values()) {
            konsole.ausgeben(modus.getDokumentation() + System.lineSeparator());
        }
    }
}
