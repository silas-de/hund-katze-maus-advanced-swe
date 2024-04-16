package org.example.hundkatzemaus.domain;

public enum BesitzerUnbekannt implements Besitzer {
    UNBEKANNT;

    @Override
    public String listenEintrag() {
        return "unbekannt";
    }
}
