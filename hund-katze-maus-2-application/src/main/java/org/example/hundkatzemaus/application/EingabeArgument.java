package org.example.hundkatzemaus.application;

import java.util.Objects;

abstract class EingabeArgument implements Argument {
    private final String name;

    public EingabeArgument(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public EingabeArgument(String name, String alias) {
        this.name = Objects.requireNonNull(name);
    }

    public String getDokumentation() {
        return "<" + name + ">";
    }
}
