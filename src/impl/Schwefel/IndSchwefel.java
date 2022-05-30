package impl.Schwefel;

import java.util.List;
import java.util.Random;

import model.Individuo;

public class IndSchwefel extends Individuo {

    List<Double> genes;

    protected IndSchwefel(int dimensao, Double maxDomain, Double minDomain) {
        this.genes = this.getGenes();
        for (int i = 0; i < dimensao; i++) {
            Random gene = new Random();
            Double alelo = minDomain + 2 * maxDomain * gene.nextDouble();
            this.genes.add(alelo);
        }
    }

    protected IndSchwefel(List<Double> genes) {
        this.genes = this.getGenes();
        this.genes.addAll(genes);
    }

    @Override
    public Double avaliar() {
        Double fitness = 418.9829 * (this.genes.size());
        Double sum = 0.0;
        for (int i = 0; i < genes.size(); i++) {
            sum += this.genes.get(i) * Math.sin(Math.sqrt(Math.abs(this.genes.get(i))));
        }

        fitness -= sum;

        return fitness;
    }

    @Override
    public String toString() {
        return this.genes.toString();
    }
}
