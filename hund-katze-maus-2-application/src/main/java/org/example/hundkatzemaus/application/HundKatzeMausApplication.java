package org.example.hundkatzemaus.application;

import java.io.Closeable;
import java.io.IOException;

public class HundKatzeMausApplication implements Closeable {
    private final Konsole konsole;

    public HundKatzeMausApplication(Konsole konsole) {
        this.konsole = konsole;
    }

    public void run(String[] args) {
        Modus modus = Modus.findeModus(args);
        modus.ausführen(args, konsole);
    }

    @Override
    public void close() throws IOException {
        konsole.close();
    }
}
