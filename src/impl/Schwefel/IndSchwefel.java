package impl.Schwefel;

import java.util.List;
import java.util.Random;

import model.Individuo;

public class IndSchwefel extends Individuo {

    private IndSchwefel(int dimensao, Double maxDomain, Double minDomain) {
        for (int i = 0; i < dimensao; i++) {
            Random gene = new Random();
            Double alelo = minDomain + 2 * maxDomain * gene.nextDouble();
            this.setGenes(alelo);
        }
    }

    private IndSchwefel(List<Double> alelos) {
        this.setGenes(alelos);
    }

    protected static Individuo getIndividuo(int dimensao, Double maxDomain, Double minDomain) {
        IndSchwefel ind = new IndSchwefel(dimensao, maxDomain, minDomain);
        return ind;
    }
    
    protected static Individuo getIndividuo(List<Double> genes) {
        IndSchwefel ind = new IndSchwefel(genes);
        return ind;
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
