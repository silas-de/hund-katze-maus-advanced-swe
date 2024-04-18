package org.example.hundkatzemaus.application;

import org.example.hundkatzemaus.domain.HandlungsIntervall;
import org.example.hundkatzemaus.domain.Tierart;
import org.example.hundkatzemaus.domain.TierartAttribut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Optional;

public enum ProgrammTierartHinzufügen implements Programm {
    INSTANCE;

    @Override
    public void ausführen(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Tierart hinzufügen");
            Optional<String> name = Dialog.textFrageStellen("Name:", false, reader);
            if (name.isEmpty())
                System.exit(1);

            boolean exotisch = tierartAttributErfragen("exotisch", reader);
            boolean heimisch = tierartAttributErfragen("heimisch", reader);
            boolean wild = tierartAttributErfragen("wild", reader);

            int fütterungsintervallTage = Dialog.nichtnegativeGanzzahlErfragen("Tiere dieser Art werden üblicherweise alle [...] Tage gefüttert:", reader);
            if (fütterungsintervallTage == -1)
                System.exit(1);
            HandlungsIntervall fütterungsIntervall = new HandlungsIntervall(fütterungsintervallTage);
            int fütterungsintervallHäufigkeit = Dialog.nichtnegativeGanzzahlErfragen("Wie oft wird diese Art am Tag gefüttert?", reader);
            if (fütterungsintervallHäufigkeit == -1)
                System.exit(1);
            for (int i = 0; i < fütterungsintervallHäufigkeit; i++) {
                System.out.print("Uhrzeit der Fütterung (hh:mm): ");
                String uhrzeit = reader.readLine();
                fütterungsIntervall.um(LocalTime.parse(uhrzeit));
            }

            int untersuchungsintervallTage = Dialog.nichtnegativeGanzzahlErfragen("Tiere dieser Art werden üblicherweise alle [...] Tage untersucht:", reader);
            HandlungsIntervall untersuchungsIntervall = new HandlungsIntervall(untersuchungsintervallTage);
            int untersuchungsintervallHäufigkeit = Dialog.nichtnegativeGanzzahlErfragen("Wie oft wird diese Art an jedem Untersuchungstag untersucht?", reader);
            for (int i = 0; i < untersuchungsintervallHäufigkeit; i++) {
                System.out.print("Uhrzeit der Untersuchung (hh:mm): ");
                String uhrzeit = reader.readLine();
                untersuchungsIntervall.um(LocalTime.parse(uhrzeit));
            }

            Tierart tierart = new Tierart.Builder()
                    .name(name.get())
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
        Optional<Boolean> exotisch = Dialog.jaNeinFrageStellen("Ist das Tier " + attributName + "?", reader);
        return exotisch.orElse(false);
    }
}
