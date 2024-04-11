package org.example.hundkatzemaus.application;

import java.util.Objects;

/**
 * Feste Argumente können in der langen Form (z.B. --belegung) und in der kurzen Form (z.B. -b) vorkommen.
 * Kurze Formen (Aliase) sind optional.
 */
class FestesArgument implements Argument {
    private final String name, alias;

    public FestesArgument(String name, String alias) {
        this.name = Objects.requireNonNull(name);
        this.alias = alias;
    }

    @Override
    public boolean entsprichtEingabe(String eingabe) {
        Objects.requireNonNull(eingabe);
        if (eingabe.startsWith("--") && eingabe.substring(2).equals(name)) {
            return true;
        }
        return eingabe.startsWith("-") && eingabe.substring(1).equals(alias);
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
