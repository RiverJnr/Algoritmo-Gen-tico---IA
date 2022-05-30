package impl.CrossInTray;

import java.util.List;
import java.util.Random;

import model.Individuo;

public class IndCrossInTray extends Individuo {

    protected IndCrossInTray(int dimensao, Double maxDomain, Double minDomain) {
        if (dimensao <= 2) {
            for (int i = 0; i < dimensao; i++) {
                Random gene = new Random();
                Double alelo = minDomain + 2 * maxDomain * gene.nextDouble();
                this.setGenes(alelo);
            }
        }
    }

    protected IndCrossInTray(List<Double> alelos) {
        this.setGenes(alelos);
    }

    @Override
    public Double avaliar() {
        Double func = Math.abs(
                Math.sin(this.getGenes().get(0)) *
                        Math.sin(this.getGenes().get(1)) *
                        Math.exp(
                                Math.abs(100 - (Math.sqrt(
                                        Math.pow(this.getGenes().get(0), 2) +
                                                Math.pow(this.getGenes().get(1), 2)))
                                        / Math.PI)))
                + 1;
        Double fitness = Math.pow(func, 0.1) * (-0.0001);

        return fitness;
    }

    @Override
    public String toString() {
        return this.getGenes().toString();
    }
}
