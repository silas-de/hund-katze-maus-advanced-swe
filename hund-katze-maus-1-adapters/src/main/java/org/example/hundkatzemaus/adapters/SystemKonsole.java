package org.example.hundkatzemaus.adapters;

import org.example.hundkatzemaus.application.Konsole;

import java.io.*;

public class SystemKonsole implements Konsole {
    private static final PrintStream ausgabe = System.out;
    private static final BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));

    public void ausgeben(String text) {
        ausgabe.print(text);
    }

    public String einlesen() throws IOException {
        return eingabe.readLine();
    }

    @Override
    public void close() throws IOException {
        eingabe.close();
    }
}
