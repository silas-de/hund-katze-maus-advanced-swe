package org.example.hundkatzemaus.application;

import java.util.Objects;

public enum Modus {
    BELEGUNG_ANZEIGEN("Belegung der Räumlichkeiten anzeigen", new Argument[]{new FestesArgument("belegung", "b")}, ProgrammHilfe.INSTANCE),
    BELEGUNG_ANZEIGEN_RAUM("Belegung einer Räumlichkeit anzeigen", new Argument[]{new FestesArgument("belegung", "b"), new EingabeArgument("Raumnummer") {
        @Override
        public boolean entsprichtEingabe(String eingabe) {
            return true;
        }
    }}, ProgrammHilfe.INSTANCE),
    FÜTTERUNGSPLAN_ANZEIGEN("Heute anstehende Fütterungen anzeigen", new Argument[]{new FestesArgument("fütterungsplan", "fp")}, ProgrammHilfe.INSTANCE),
    HILFE("Hilfe bei der Bedienung", new Argument[]{new FestesArgument("hilfe", "h")}, ProgrammHilfe.INSTANCE),
    PFLEGE_ERFASSEN("Eine Pflegemaßnahme erfassen", new Argument[]{new FestesArgument("pflege-erfassen", "p")}, ProgrammHilfe.INSTANCE),
    FÜTTERUNG_ERFASSEN("Eine Fütterung erfassen", new Argument[]{new FestesArgument("fütterung-erfassen", "f")}, ProgrammHilfe.INSTANCE),
    TIERE_ÜBERSICHT("Übersicht über alle Tiere anzeigen", new Argument[]{new FestesArgument("tier-übersicht", "t")}, ProgrammTiereÜbersicht.INSTANCE),
    FLUKTUATION_ANZEIGEN("Fluktuation der Tiere anzeigen", new Argument[]{new FestesArgument("fluktuation", "fl")}, ProgrammFluktuation.INSTANCE),
    TIERART_HINZUFÜGEN("Eine Tierart hinzufügen", new Argument[]{new FestesArgument("tierart-hinzufügen", "ta")}, ProgrammTierartHinzufügen.INSTANCE),
    ;

    private final String beschreibung;
    private final Argument[] argumente;
    private final Programm programm;

    Modus(String beschreibung, Argument[] argumente, Programm programm) {
        this.beschreibung = Objects.requireNonNull(beschreibung);
        this.argumente = Objects.requireNonNull(argumente);
        this.programm = Objects.requireNonNull(programm);
    }

    public static Modus findeModus(String[] eingaben) {
        Objects.requireNonNull(eingaben);
        if (eingaben.length == 0) {
            return HILFE;
        }
        for (Modus modus : Modus.values()) {
            if (modus.entsprichtEingaben(eingaben)) {
                return modus;
            }
        }
        return HILFE;
    }

    public void ausführen(String[] eingaben, Konsole konsole) {
        programm.ausführen(eingaben, konsole);
    }

    public boolean entsprichtEingaben(String[] eingaben) {
        Objects.requireNonNull(eingaben);
        if (eingaben.length == 0) {
            return false;
        }
        if (eingaben.length != argumente.length) {
            return false;
        }
        for (int i = 0; i < eingaben.length; i++) {
            if (!argumente[i].entsprichtEingabe(eingaben[i])) {
                return false;
            }
        }
        return true;
    }

    public String getDokumentation() {
        StringBuilder dokumentation = new StringBuilder();
        for (Argument argument : argumente) {
            dokumentation.append(argument.getDokumentation());
            dokumentation.append(" ");
        }
        dokumentation.append("\t\t");
        dokumentation.append(beschreibung);
        return dokumentation.toString();
    }
}
