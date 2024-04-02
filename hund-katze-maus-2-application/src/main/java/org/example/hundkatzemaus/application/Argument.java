package org.example.hundkatzemaus.application;

/**
 * Argumente sind die Bestandteile einer Eingabe, die von der Anwendung verarbeitet werden.
 * Sie sind durch Leerzeichen getrennt.
 */
interface Argument {
    boolean entsprichtEingabe(String eingabe);
    String getDokumentation();
}

/**
 * Feste Argumente können in der langen Form (z.B. --belegung) und in der kurzen Form (z.B. -b) vorkommen.
 * Kurze Formen (Aliase) sind optional.
 */
class FestesArgument implements Argument {
    private final String name, alias;

    public FestesArgument(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Wert darf nicht null sein");
        }
        this.name = name;
        this.alias = null;
    }

    public FestesArgument(String name, String alias) {
        if (name == null) {
            throw new IllegalArgumentException("Wert darf nicht null sein");
        }
        this.name = name;
        this.alias = alias;
    }

    @Override
    public boolean entsprichtEingabe(String eingabe) {
        if (eingabe == null) {
            throw new IllegalArgumentException("Eingabe darf nicht null sein");
        }
        if (eingabe.startsWith("--") && eingabe.substring(2).equals(name)) {
            return true;
        }
        return alias != null && eingabe.startsWith("-") && eingabe.substring(1).equals(alias);
    }

    public String getDokumentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(name);
        if (alias != null) {
            sb.append(" (-").append(alias).append(")");
        }
        return sb.toString();
    }
}

abstract class EingabeArgument implements Argument {
    private final String name;

    public EingabeArgument(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name darf nicht null sein");
        }
        this.name = name;
    }

    public EingabeArgument(String name, String alias) {
        if (name == null) {
            throw new IllegalArgumentException("Name darf nicht null sein");
        }
        this.name = name;
    }

    public String getDokumentation() {
        return "<" + name + ">";
    }
}
