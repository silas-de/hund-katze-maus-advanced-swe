package org.example.hundkatzemaus.application;

import java.util.Optional;

public enum HundKatzeMausApplication {
    instance;

    public void run(String[] args) {
        Modus modus = Modus.findeModus(args);
        modus.ausführen(args);
    }
}
