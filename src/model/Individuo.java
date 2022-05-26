package model;

import java.util.List;

public abstract class Individuo implements Comparable<Individuo> {
    protected Double avaliacao;

    public abstract Double avaliar();

    public abstract List<Individuo> crossover(Individuo ind);

    public abstract Individuo getMutant();

    public abstract List<Double> getGenes();
    
    public Double getAvaliacao() {
        if (this.avaliacao == null) {
            this.avaliacao = this.avaliar();
        }
        return this.avaliacao;
    }
    
    @Override
    public int compareTo(Individuo ind) {
        if (this.getAvaliacao() > ind.getAvaliacao()) {
            return -1;
        } else {
            if (this.getAvaliacao() < ind.getAvaliacao()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
