package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.domain.Tier;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum ProgrammTiereÜbersicht implements Programm {
    INSTANCE;

    @Override
    public void ausführen(String[] args) {
        long anzahlTiere = TierRepository.INSTANCE.anzahlTiere();
        System.out.println("Insgesamt " + anzahlTiere + " Tiere");

        List<Tier> tiereZuletztAufgenommen = TierRepository.INSTANCE.aufgenommenInDenLetztenTagen(7);
        System.out.println("Neu aufgenommen in den letzten 7 Tagen: " + tiereZuletztAufgenommen.size() + " Tiere");
        tiereZuletztAufgenommen.stream()
                .collect(Collectors.groupingBy(Tier::getTierart))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(entry -> -entry.getValue().size()))
                .forEach(entry -> System.out.println("- " + entry.getValue().size() + "x " + entry.getKey()));
    }
}
