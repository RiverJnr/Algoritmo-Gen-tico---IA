package impl.DixonPrice;

import java.util.List;
import java.util.Random;

import model.Individuo;

public class IndDixonPrice extends Individuo {

    private IndDixonPrice(int dimensao, Double maxDomain, Double minDomain) {
        for (int i = 0; i < dimensao; i++) {
            Random gene = new Random();
            Double alelo = minDomain + 2 * maxDomain * gene.nextDouble();
            this.setGenes(alelo);
        }
    }

    private IndDixonPrice(List<Double> alelos) {
        this.setGenes(alelos);
    }

    protected static Individuo getIndividuo(int dimensao, Double maxDomain, Double minDomain) {
        IndDixonPrice ind = new IndDixonPrice(dimensao, maxDomain, minDomain);
        return ind;
    }
    
    protected static Individuo getIndividuo(List<Double> genes) {
        IndDixonPrice ind = new IndDixonPrice(genes);
        return ind;
    }

    @Override
    public Double avaliar() {
        Double fitness = Math.pow(this.getGenes().get(0) - 1, 2);
        Double sum = 0.0;
        
        for (int i = 1; i < this.getGenes().size(); i++) {
            sum = i * Math.pow(
                    2 * Math.pow(this.getGenes().get(i), 2) - this.getGenes().get(i - 1), 2);
        }

        fitness += sum;

        return fitness;
    }

    @Override
    public String toString() {
        return this.getGenes().toString();
    }
}
