package org.example.hundkatzemaus.main;

import org.example.hundkatzemaus.application.HundKatzeMausApplication;

public class Main {

    public static void main(String[] args) {
        // Plugin: Ein-/Ausgabe
        // Plugin: Datenbankschnittstelle
        HundKatzeMausApplication.instance.run(args/*, plugin*/);
    }
}
