package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Individuo implements Comparable<Individuo> {
    protected Double avaliacao;
    protected List<Double> cromossomos = new ArrayList<>();

    public abstract Double avaliar();

    // public abstract List<Individuo> crossover(Individuo ind);
    public List<List<Double>> crossover(Individuo ind, Double maxDomain, Double minDomain) {
        Random rand = new Random();
        List<Double> novoGeneP1 = new ArrayList<>(this.cromossomos);
        List<Double> novoGeneP2 = new ArrayList<>(ind.getGenes());
        Double alpha = 0.0;

        for (int i = 0; i < novoGeneP1.size(); i++) {
            alpha = rand.nextGaussian(0, 0.1);
            Double genFilho = this.cromossomos.get(i)
                    + alpha * (Math.abs(this.cromossomos.get(i) - ind.getGenes().get(i)));
            if (genFilho > maxDomain) {
                genFilho = maxDomain;
            }
            if (genFilho < minDomain) {
                genFilho = minDomain;
            }
            novoGeneP1.set(i, genFilho);
        }

        for (int i = 0; i < novoGeneP2.size(); i++) {
            alpha = rand.nextGaussian(0, 0.1);
            Double genFilho = ind.getGenes().get(i)
                    + alpha * (Math.abs(this.cromossomos.get(i) - ind.getGenes().get(i)));
            if (genFilho > maxDomain) {
                genFilho = maxDomain;
            }
            if (genFilho < minDomain) {
                genFilho = minDomain;
            }
            novoGeneP2.set(i, genFilho);
        }

        // Criar os 2 objetos dos filhos e atribuilos na lista de retorno
        List<List<Double>> filhos = new ArrayList<>();
        filhos.add(novoGeneP1);
        filhos.add(novoGeneP2);
        return filhos;
    }

    public List<Double> getMutant() {
        List<Double> novoGenes = new ArrayList<>(this.cromossomos);
        boolean isMutant = true;

        Random rand = new Random();
        for (int i = 0; i < this.cromossomos.size(); i++) {
            if (rand.nextDouble() < 0.1) {
                novoGenes.set(i, novoGenes.get(i) + rand.nextGaussian());
                if (isMutant) {
                    isMutant = false;
                }
            }
        }

        if (isMutant) {
            int index = rand.nextInt(this.cromossomos.size());
            novoGenes.set(index, novoGenes.get(index) + rand.nextGaussian());
        }

        return novoGenes;
    }

    public Double getAvaliacao() {
        if (this.avaliacao == null) {
            this.avaliacao = this.avaliar();
        }
        return this.avaliacao;
    }

    public List<Double> getGenes() {
        return this.cromossomos;
    }

    public void setGenes(Double alelo) {
        this.cromossomos.add(alelo);
    }

    public void setGenes(List<Double> alelos) {
        this.cromossomos.addAll(alelos);
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
