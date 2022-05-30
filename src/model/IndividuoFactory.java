package model;

import java.util.List;

public interface IndividuoFactory {
    
    public Individuo getIndividuo(Double maxDomain, Double minDomain);

    public Individuo getIndividuo(List<Double> genes);
}
