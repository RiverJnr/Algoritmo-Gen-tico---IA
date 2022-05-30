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

    // @Override
    // public List<Individuo> crossover(Individuo ind) {
    //     Random rand = new Random();
    //     IndDixonPrice newInd = (IndDixonPrice) ind;
    //     List<Double> novoGeneP1 = new ArrayList<>(this.genes);
    //     List<Double> novoGeneP2 = new ArrayList<>(newInd.getGenes());
    //     Double alpha = 0.0;

    //     for (int i = 0; i < novoGeneP1.size(); i++) {
    //         alpha = rand.nextGaussian(0, 0.1);
    //         Double genFilho = this.genes.get(i) + alpha * (Math.abs(this.genes.get(i) - newInd.getGenes().get(i)));
    //         if (genFilho > 500) {
    //             genFilho = 500.0;
    //         }
    //         if (genFilho < -500) {
    //             genFilho = -500.0;
    //         }
    //         novoGeneP1.set(i, genFilho);
    //     }

    //     for (int i = 0; i < novoGeneP2.size(); i++) {
    //         alpha = rand.nextGaussian(0, 0.1);
    //         Double genFilho = newInd.getGenes().get(i) + alpha * (Math.abs(this.genes.get(i) - newInd.getGenes().get(i)));
    //         if (genFilho > 500) {
    //             genFilho = 500.0;
    //         }
    //         if (genFilho < -500) {
    //             genFilho = -500.0;
    //         }
    //         novoGeneP2.set(i, genFilho);
    //     }

    //     // Criar os 2 objetos dos filhos e atribuilos na lista de retorno
    //     List<Individuo> filhos = new ArrayList<>();
    //     filhos.add(new IndDixonPrice(novoGeneP1));
    //     filhos.add(new IndDixonPrice(novoGeneP2));
    //     return filhos;
    // }

    // @Override
    // public Individuo getMutant() {
    //     List<Double> novoGenes = new ArrayList<>(this.genes);
    //     boolean isMutant = true;

    //     Random rand = new Random();
    //     for (int i = 0; i < this.genes.size(); i++) {
    //         if (rand.nextDouble() < 0.1) {
    //             novoGenes.set(i, novoGenes.get(i) + rand.nextGaussian());
    //             if (isMutant) {
    //                 isMutant = false;
    //             }
    //         }
    //     }

    //     if (isMutant) {
    //         int index = rand.nextInt(this.genes.size());
    //         novoGenes.set(index, novoGenes.get(index) + rand.nextGaussian());
    //     }

    //     return new IndDixonPrice(novoGenes);
    // }

    // @Override
    // public List<Double> getGenes() {
    //     return this.genes;
    // }

    @Override
    public String toString() {
        return this.genes.toString();
    }
}
