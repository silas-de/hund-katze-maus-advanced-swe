package org.example.hundkatzemaus.application;

import java.io.Closeable;
import java.io.IOException;

public interface Konsole extends Closeable {
    void ausgeben(String text);

    String einlesen() throws IOException;
}
