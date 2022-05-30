package impl.Schwefel;

import java.util.List;
import java.util.Random;

import model.Individuo;

public class IndSchwefel extends Individuo {

    protected IndSchwefel(int dimensao, Double maxDomain, Double minDomain) {
        for (int i = 0; i < dimensao; i++) {
            Random gene = new Random();
            Double alelo = minDomain + 2 * maxDomain * gene.nextDouble();
            this.setGenes(alelo);
        }
    }

    protected IndSchwefel(List<Double> alelos) {
        this.setGenes(alelos);
    }

    @Override
    public Double avaliar() {
        Double fitness = 418.9829 * (this.getGenes().size());
        Double sum = 0.0;
        for (int i = 0; i < this.getGenes().size(); i++) {
            sum += this.getGenes().get(i) * Math.sin(Math.sqrt(Math.abs(this.getGenes().get(i))));
        }

        fitness -= sum;

        return fitness;
    }

    @Override
    public String toString() {
        return this.getGenes().toString();
    }
}
