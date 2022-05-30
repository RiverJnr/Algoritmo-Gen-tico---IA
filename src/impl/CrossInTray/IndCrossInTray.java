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

    // @Override
    // public List<Individuo> crossover(Individuo ind) {
    // Random rand = new Random();
    // IndCrossInTray newInd = (IndCrossInTray) ind;
    // List<Double> novoGeneP1 = new ArrayList<>(this.genes);
    // List<Double> novoGeneP2 = new ArrayList<>(newInd.getGenes());
    // Double alpha = 0.0;

    // for (int i = 0; i < novoGeneP1.size(); i++) {
    // alpha = rand.nextGaussian(0, 0.1);
    // Double genFilho = this.genes.get(i) + alpha * (Math.abs(this.genes.get(i) -
    // newInd.getGenes().get(i)));
    // if (genFilho > 500) {
    // genFilho = 500.0;
    // }
    // if (genFilho < -500) {
    // genFilho = -500.0;
    // }
    // novoGeneP1.set(i, genFilho);
    // }

    // for (int i = 0; i < novoGeneP2.size(); i++) {
    // alpha = rand.nextGaussian(0, 0.1);
    // Double genFilho = newInd.getGenes().get(i)
    // + alpha * (Math.abs(this.genes.get(i) - newInd.getGenes().get(i)));
    // if (genFilho > 500) {
    // genFilho = 500.0;
    // }
    // if (genFilho < -500) {
    // genFilho = -500.0;
    // }
    // novoGeneP2.set(i, genFilho);
    // }

    // // Criar os 2 objetos dos filhos e atribuilos na lista de retorno
    // List<Individuo> filhos = new ArrayList<>();
    // filhos.add(new IndCrossInTray(novoGeneP1));
    // filhos.add(new IndCrossInTray(novoGeneP2));
    // return filhos;
    // }

    // @Override
    // public Individuo getMutant() {
    // List<Double> novoGenes = new ArrayList<>(this.genes);
    // boolean isMutant = true;

    // Random rand = new Random();
    // for (int i = 0; i < this.genes.size(); i++) {
    // if (rand.nextDouble() < 0.1) {
    // novoGenes.set(i, novoGenes.get(i) + rand.nextGaussian());
    // if (isMutant) {
    // isMutant = false;
    // }
    // }
    // }

    // if (isMutant) {
    // int index = rand.nextInt(this.genes.size());
    // novoGenes.set(index, novoGenes.get(index) + rand.nextGaussian());
    // }

    // return new IndCrossInTray(novoGenes);
    // }

    // @Override
    // public List<Double> getGenes() {
    // return this.genes;
    // }

    @Override
    public String toString() {
        return this.genes.toString();
    }
}
