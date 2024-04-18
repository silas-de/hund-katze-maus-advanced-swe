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
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {

            System.out.println("Tierart hinzufügen");
            System.out.print("Name: ");
            String name = reader.readLine();

            System.out.print("Ist das Tier exotisch? [j/n]: ");
            String exotisch = reader.readLine();
            System.out.print("Ist das Tier heimisch? [j/n]: ");
            String heimisch = reader.readLine();
            System.out.print("Ist das Tier wild? [j/n]: ");
            String wild = reader.readLine();

            System.out.print("Tiere dieser Art werden üblicherweise alle [...] Tage gefüttert: ");
            int fütterungsintervallTage = Integer.parseInt(reader.readLine());
            System.out.print("Wie oft wird diese Art an jedem Fütterungstag gefüttert? ");
            HandlungsIntervall fütterungsIntervall = new HandlungsIntervall(fütterungsintervallTage);
            int fütterungsintervallHäufigkeit = Integer.parseInt(reader.readLine());
            for (int i = 0; i < fütterungsintervallHäufigkeit; i++) {
                System.out.print("Uhrzeit der Fütterung (hh:mm): ");
                String uhrzeit = reader.readLine();
                fütterungsIntervall.um(LocalTime.parse(uhrzeit));
            }

            System.out.print("Tiere dieser Art werden üblicherweise alle [...] Tage untersucht: ");
            int untersuchungsintervallTage = Integer.parseInt(reader.readLine());
            System.out.print("Wie oft wird diese Art an jedem Untersuchungstag untersucht? ");
            HandlungsIntervall untersuchungsIntervall = new HandlungsIntervall(untersuchungsintervallTage);
            int untersuchungsintervallHäufigkeit = Integer.parseInt(reader.readLine());
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
            if ("j".equals(exotisch) || "J".equals(exotisch)) {
                tierart.mitAttribut(TierartAttribut.EXOTISCH);
            }
            if ("j".equals(heimisch) || "J".equals(heimisch)) {
                tierart.mitAttribut(TierartAttribut.HEIMISCH);
            }
            if ("j".equals(wild) || "J".equals(wild)) {
                tierart.mitAttribut(TierartAttribut.WILD);
            }
            TierartRepository tierartRepository = new TierartRepository();
            tierartRepository.registriere(tierart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
