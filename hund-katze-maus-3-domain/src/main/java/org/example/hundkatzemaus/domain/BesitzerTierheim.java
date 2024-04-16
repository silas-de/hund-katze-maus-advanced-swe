package org.example.hundkatzemaus.domain;

public enum BesitzerTierheim implements Besitzer {
    TIERHEIM;

    @Override
    public String listenEintrag() {
        return "Tierheim";
    }
}
