package org.example.hundkatzemaus.domain;

public enum BesitzerNiemand implements Besitzer {
    NIEMAND;

    @Override
    public String listenEintrag() {
        return "niemand";
    }
}
