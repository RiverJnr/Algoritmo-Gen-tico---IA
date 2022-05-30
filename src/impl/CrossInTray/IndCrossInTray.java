package impl.CrossInTray;

import java.util.List;
import java.util.Random;

import model.Individuo;

public class IndCrossInTray extends Individuo {

    List<Double> genes;

    protected IndCrossInTray(int dimensao, Double maxDomain, Double minDomain) {
        this.genes = this.getGenes();
        if (dimensao <= 2) {
            for (int i = 0; i < dimensao; i++) {
                Random gene = new Random();
                Double alelo = minDomain + 2 * maxDomain * gene.nextDouble();
                this.genes.add(alelo);
            }
        }
    }

    protected IndCrossInTray(List<Double> genes) {
        this.genes = this.getGenes();
        this.genes.addAll(genes);
    }

    @Override
    public Double avaliar() {
        Double func = Math.abs(
                Math.sin(this.genes.get(0)) *
                        Math.sin(this.genes.get(1)) *
                        Math.exp(
                                Math.abs(100 - (Math.sqrt(
                                        Math.pow(this.genes.get(0), 2) +
                                                Math.pow(this.genes.get(1), 2)))
                                        / Math.PI)))
                + 1;
        Double fitness = Math.pow(func, 0.1) * (-0.0001);

        return fitness;
    }

    @Override
    public String toString() {
        return this.genes.toString();
    }
}
