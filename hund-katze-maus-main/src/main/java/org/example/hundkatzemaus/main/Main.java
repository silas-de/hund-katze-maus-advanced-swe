package org.example.hundkatzemaus.main;

import org.example.hundkatzemaus.adapters.SystemKonsole;
import org.example.hundkatzemaus.application.HundKatzeMausApplication;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Plugin: Datenbankschnittstelle
        try (HundKatzeMausApplication application = new HundKatzeMausApplication()) {
            application.run(args);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
