package impl.DixonPrice;

import java.util.List;
import java.util.Random;

import model.Individuo;

public class IndDixonPrice extends Individuo {

    List<Double> genes;

    protected IndDixonPrice(int dimensao, Double maxDomain, Double minDomain) {
        this.genes = this.getGenes();
        for (int i = 0; i < dimensao; i++) {
            Random gene = new Random();
            Double alelo = minDomain + 2 * maxDomain * gene.nextDouble();
            this.genes.add(alelo);
        }
    }

    protected IndDixonPrice(List<Double> genes) {
        this.genes = this.getGenes();
        this.genes.addAll(genes);
    }

    @Override
    public Double avaliar() {
        Double fitness = Math.pow(this.genes.get(0) - 1, 2);
        Double sum = 0.0;
        
        for (int i = 1; i < this.genes.size(); i++) {
            sum = i * Math.pow(
                    2 * Math.pow(this.genes.get(i), 2) - this.genes.get(i - 1), 2);
        }

        fitness += sum;

        return fitness;
    }

    @Override
    public String toString() {
        return this.genes.toString();
    }
}
