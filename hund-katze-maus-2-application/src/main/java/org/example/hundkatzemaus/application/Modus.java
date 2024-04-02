package org.example.hundkatzemaus.application;

public enum Modus {
    BELEGUNG_ANZEIGEN("Belegung der Räumlichkeiten anzeigen", new Argument[] { new FestesArgument("belegung", "b") }, ProgrammHilfe.instance ),
    BELEGUNG_ANZEIGEN_RAUM("Belegung einer Räumlichkeit anzeigen", new Argument[] { new FestesArgument("belegung", "b"), new EingabeArgument("Raumnummer") {
        @Override
        public boolean entsprichtEingabe(String eingabe) {
            return true;
        }
    } }, ProgrammHilfe.instance ),
    FÜTTERUNGSPLAN_ANZEIGEN("heute anstehende Fütterungen anzeigen", new Argument[] { new FestesArgument("fütterungsplan", "fp") }, ProgrammHilfe.instance ),
    HILFE("Hilfe bei der Bedienung", new Argument[] { new FestesArgument("hilfe", "h") }, ProgrammHilfe.instance ),
    PFLEGE_ERFASSEN("Eine Pflegemaßnahme erfassen", new Argument[] { new FestesArgument("pflege-erfassen", "p") }, ProgrammHilfe.instance ),
    FÜTTERUNG_ERFASSEN("Eine Fütterung erfassen", new Argument[] { new FestesArgument("fütterung-erfassen", "f") }, ProgrammHilfe.instance ),
    ;

    private final String beschreibung;
    private final Argument[] argumente;
    private final Programm programm;

    Modus(String beschreibung, Argument[] argumente, Programm programm) {
        if (beschreibung == null) {
            throw new IllegalArgumentException("Beschreibung darf nicht null sein");
        }
        if (argumente == null) {
            throw new IllegalArgumentException("Argumente dürfen nicht null sein");
        }
        this.beschreibung = beschreibung;
        this.argumente = argumente;
        this.programm = programm;
    }

    public static Modus findeModus(String[] eingaben) {
        if (eingaben == null) {
            throw new IllegalArgumentException("Eingaben dürfen nicht null sein");
        }
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

    public void ausführen(String[] eingaben) {
        programm.ausführen(eingaben);
    }

    public boolean entsprichtEingaben(String[] eingaben) {
        if (eingaben == null) {
            throw new IllegalArgumentException("Eingaben dürfen nicht null sein");
        }
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
        dokumentation.append(beschreibung);
        return dokumentation.toString();
    }
}
