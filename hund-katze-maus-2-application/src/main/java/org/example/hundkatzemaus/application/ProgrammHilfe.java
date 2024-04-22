package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.adapters.SystemKonsole;

public enum ProgrammHilfe implements Programm {
    INSTANCE;

    @Override
    public void ausführen(String[] args, SystemKonsole konsole) {
        System.out.println("Benutzung:");
        for (Modus modus : Modus.values()) {
            System.out.println(modus.getDokumentation());
        }
    }
}
