package org.example.hundkatzemaus.main;

import org.example.hundkatzemaus.adapters.SystemKonsole;
import org.example.hundkatzemaus.application.HundKatzeMausApplication;
import org.example.hundkatzemaus.application.Konsole;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Konsole konsole = new SystemKonsole();
        // Plugin: Datenbankschnittstelle
        try (HundKatzeMausApplication application = new HundKatzeMausApplication(konsole)) {
            application.run(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
