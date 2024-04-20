package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.domain.HandlungsIntervall;
import org.example.hundkatzemaus.domain.Tierart;
import org.example.hundkatzemaus.domain.TierartAttribut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public enum ProgrammTierartHinzufügen implements Programm {
    INSTANCE;

    @Override
    public void ausführen(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Tierart hinzufügen");
            String name;
            try {
                name = Dialog.textFrageStellen("Name:", false, reader);
            } catch (Dialog.EingabeException | IOException e) {
                System.exit(1);
                return;
            }

            boolean exotisch = tierartAttributErfragen("exotisch", reader);
            boolean heimisch = tierartAttributErfragen("heimisch", reader);
            boolean wild = tierartAttributErfragen("wild", reader);

            int fütterungsintervallTage, fütterungsintervallHäufigkeit;
            HandlungsIntervall fütterungsIntervall;
            try {
                fütterungsintervallTage = Dialog.nichtnegativeGanzzahlErfragen("Tiere dieser Art werden üblicherweise alle [...] Tage gefüttert:", reader);
                fütterungsIntervall = new HandlungsIntervall(fütterungsintervallTage);
                fütterungsintervallHäufigkeit = Dialog.nichtnegativeGanzzahlErfragen("Wie oft wird diese Art am Tag gefüttert?", reader);
            } catch (Dialog.EingabeException | IOException e) {
                System.err.println("Bitte geben Sie eine positive Ganzzahl ein.");
                System.exit(1);
                return;
            }
            for (int i = 0; i < fütterungsintervallHäufigkeit; i++) {
                System.out.print("Uhrzeit der Fütterung (hh:mm): ");
                String uhrzeit = reader.readLine();
                fütterungsIntervall.um(LocalTime.parse(uhrzeit));
            }

            int untersuchungsintervallTage, untersuchungsintervallHäufigkeit;
            HandlungsIntervall untersuchungsIntervall;
            try {
                untersuchungsintervallTage = Dialog.nichtnegativeGanzzahlErfragen("Tiere dieser Art werden üblicherweise alle [...] Tage untersucht:", reader);
                untersuchungsIntervall = new HandlungsIntervall(untersuchungsintervallTage);
                untersuchungsintervallHäufigkeit = Dialog.nichtnegativeGanzzahlErfragen("Wie oft wird diese Art an jedem Untersuchungstag untersucht?", reader);
            } catch (Dialog.EingabeException | IOException e) {
                System.err.println("Bitte geben Sie eine positive Ganzzahl ein.");
                System.exit(1);
                return;
            }
            for (int i = 0; i < untersuchungsintervallHäufigkeit; i++) {
                System.out.print("Uhrzeit der Untersuchung (hh:mm): ");
                String uhrzeit = reader.readLine();
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

    private static boolean tierartAttributErfragen(String attributName, BufferedReader reader) {
        try {
            return Dialog.jaNeinFrageStellen("Ist das Tier " + attributName + "?", reader);
        } catch (Dialog.EingabeException | IOException e) {
            return false;
        }
    }
}
