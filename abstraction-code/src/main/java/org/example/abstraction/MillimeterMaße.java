package org.example.abstraction;

/**
 * Breite, Höhe oder Tiefe oder eine Kombination aus zwei oder allen drei Maßen.
 * @param breite Breite in Millimeter zwischen 0 und etwa 9*10^18mm bzw. 9*10^12km
 * @param höhe Höhe in Millimeter zwischen 0 und etwa 9*10^18mm bzw. 9*10^12km
 * @param tiefe Tiefe in Millimeter zwischen 0 und etwa 9*10^18mm bzw. 9*10^12km
 */
public record MillimeterMaße(Long breite, Long höhe, Long tiefe) {
    public MillimeterMaße {
        if (breite == null && höhe == null && tiefe == null) {
            throw new NullPointerException("Es dürfen höchstens zwei Maße fehlen.");
        }
        if (breite != null && breite < 0 || höhe != null && höhe < 0 || tiefe != null && tiefe < 0) {
            throw new IllegalArgumentException("Es dürfen nur positive Maße angegeben werden.");
        }
    }

    public static class Builder {
        private Long breite, höhe, tiefe;

        public Builder breite(long breite) {
            this.breite = breite;
            return this;
        }

        public Builder höhe(long höhe) {
            this.höhe = höhe;
            return this;
        }

        public Builder tiefe(long tiefe) {
            this.tiefe = tiefe;
            return this;
        }

        public MillimeterMaße build() {
            return new MillimeterMaße(breite, höhe, tiefe);
        }
    }
}
