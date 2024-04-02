package org.example.hundkatzemaus.application;

public enum ProgrammHilfe implements Programm {
    instance;

    @Override
    public void ausführen(String[] args) {
        System.out.println("Benutzung:");
        for (Modus modus : Modus.values()) {
            System.out.println(modus.getDokumentation());
        }
    }
}
