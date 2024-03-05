package org.example.hundkatzemaus.main;

import org.example.abstraction.Gewicht;

public class Main {
    public static void main(String[] args) {
        Gewicht g = Gewicht.gramm(500);
        System.out.println("Hello world!");
        System.out.println(g.toMilligramm());
        System.out.println(g.toGramm());
        System.out.println(g.toKilogramm());
        System.out.println(g.toTonnen());
    }
}
