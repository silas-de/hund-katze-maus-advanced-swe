package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.adapters.SystemKonsole;

import java.io.Closeable;
import java.io.IOException;

public class HundKatzeMausApplication implements Closeable {
    private final SystemKonsole konsole;

    public HundKatzeMausApplication() {
        this.konsole = new SystemKonsole();
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
