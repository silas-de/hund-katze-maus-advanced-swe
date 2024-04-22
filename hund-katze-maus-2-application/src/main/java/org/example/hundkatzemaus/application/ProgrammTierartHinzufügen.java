package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.adapters.SystemKonsole;
import org.example.hundkatzemaus.domain.HandlungsIntervall;
import org.example.hundkatzemaus.domain.Tierart;
import org.example.hundkatzemaus.domain.TierartAttribut;

import java.io.IOException;
import java.time.LocalTime;

public enum ProgrammTierartHinzufügen implements Programm {
    INSTANCE;

    @Override
    public void ausführen(String[] args, SystemKonsole konsole) {
        try {
            System.out.println("Tierart hinzufügen");
            String name;
            try {
                name = Dialog.textFrageStellen("Name:", false, konsole);
            } catch (Dialog.EingabeException | IOException e) {
                System.exit(1);
                return;
            }

            boolean exotisch = tierartAttributErfragen("exotisch", konsole);
            boolean heimisch = tierartAttributErfragen("heimisch", konsole);
            boolean wild = tierartAttributErfragen("wild", konsole);

            int fütterungsintervallTage, fütterungsintervallHäufigkeit;
            HandlungsIntervall fütterungsIntervall;
            try {
                fütterungsintervallTage = Dialog.nichtnegativeGanzzahlErfragen("Tiere dieser Art werden üblicherweise alle [...] Tage gefüttert:", konsole);
                fütterungsIntervall = new HandlungsIntervall(fütterungsintervallTage);
                fütterungsintervallHäufigkeit = Dialog.nichtnegativeGanzzahlErfragen("Wie oft wird diese Art am Tag gefüttert?", konsole);
            } catch (Dialog.EingabeException | IOException e) {
                System.err.println("Bitte geben Sie eine positive Ganzzahl ein.");
                System.exit(1);
                return;
            }
            for (int i = 0; i < fütterungsintervallHäufigkeit; i++) {
                System.out.print("Uhrzeit der Fütterung (hh:mm): ");
                String uhrzeit = konsole.einlesen();
                fütterungsIntervall.um(LocalTime.parse(uhrzeit));
            }

            int untersuchungsintervallTage, untersuchungsintervallHäufigkeit;
            HandlungsIntervall untersuchungsIntervall;
            try {
                untersuchungsintervallTage = Dialog.nichtnegativeGanzzahlErfragen("Tiere dieser Art werden üblicherweise alle [...] Tage untersucht:", konsole);
                untersuchungsIntervall = new HandlungsIntervall(untersuchungsintervallTage);
                untersuchungsintervallHäufigkeit = Dialog.nichtnegativeGanzzahlErfragen("Wie oft wird diese Art an jedem Untersuchungstag untersucht?", konsole);
            } catch (Dialog.EingabeException | IOException e) {
                System.err.println("Bitte geben Sie eine positive Ganzzahl ein.");
                System.exit(1);
                return;
            }
            for (int i = 0; i < untersuchungsintervallHäufigkeit; i++) {
                System.out.print("Uhrzeit der Untersuchung (hh:mm): ");
                String uhrzeit = konsole.einlesen();
                untersuchungsIntervall.um(LocalTime.parse(uhrzeit));
            }

            Tierart tierart = new Tierart.Builder()
                    .name(name)
                    .fütterungsIntervall(fütterungsIntervall)
                    .untersuchungsIntervall(untersuchungsIntervall)
                    .build();
            if (exotisch)
                tierart.mitAttribut(TierartAttribut.EXOTISCH);
            if (heimisch)
                tierart.mitAttribut(TierartAttribut.HEIMISCH);
            if (wild)
                tierart.mitAttribut(TierartAttribut.WILD);

            TierartRepository tierartRepository = new TierartRepository();
            tierartRepository.registriere(tierart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean tierartAttributErfragen(String attributName, SystemKonsole konsole) {
        try {
            return Dialog.jaNeinFrageStellen("Ist das Tier " + attributName + "?", konsole);
        } catch (Dialog.EingabeException | IOException e) {
            return false;
        }
    }
}
