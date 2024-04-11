package org.example.hundkatzemaus.domain;

import java.util.List;

public interface TierRepository {
    long anzahlTiere();
    List<Tier> aufgenommenInDenLetztenTagen(int tage);
}
