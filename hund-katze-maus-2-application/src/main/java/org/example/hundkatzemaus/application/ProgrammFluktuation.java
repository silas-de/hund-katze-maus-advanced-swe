package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.domain.Tier;

import java.util.List;

public enum ProgrammFluktuation implements Programm {
    INSTANCE;

    @Override
    public void ausführen(String[] eingaben) {
        System.out.println("Fluktuation der letzten 7 Tage:");
        List<Tier> veränderteTiere = TierRepository.INSTANCE.fluktuationInDenLetztenTagen(7);
        for (Tier tier : veränderteTiere) {
            System.out.println(tier.fluktuation());
        }
    }
}
