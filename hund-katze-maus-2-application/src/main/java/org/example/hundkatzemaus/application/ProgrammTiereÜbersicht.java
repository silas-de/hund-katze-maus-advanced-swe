package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.domain.Tier;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammTiereÜbersicht implements Programm {
    private final TierRepository tierRepository;

    public ProgrammTiereÜbersicht(TierRepository tierRepository) {
        this.tierRepository = tierRepository;
    }

    @Override
    public void ausführen(String[] args, Konsole konsole) {
        long anzahlTiere = tierRepository.anzahlTiere();
        konsole.ausgeben("Insgesamt " + anzahlTiere + " Tiere" + System.lineSeparator());

        List<Tier> tiereZuletztAufgenommen = tierRepository.aufgenommenInDenLetztenTagen(7);
        konsole.ausgeben("Neu aufgenommen in den letzten 7 Tagen: " + tiereZuletztAufgenommen.size() + " Tiere" + System.lineSeparator());
        tiereZuletztAufgenommen.stream()
                .collect(Collectors.groupingBy(Tier::getTierart))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(entry -> -entry.getValue().size()))
                .forEach(entry -> konsole.ausgeben("- " + entry.getValue().size() + "x " + entry.getKey().getName() + System.lineSeparator()));
    }
}
