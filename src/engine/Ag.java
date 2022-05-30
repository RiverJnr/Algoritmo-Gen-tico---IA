package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Individuo;
import model.IndividuoFactory;

public class Ag {
    public Individuo executar(int nPop, IndividuoFactory indFactory,
            int nGeracoes, Double minGlobal,
            Double maxDomain,
            Double minDomain) {
        List<Individuo> popTotal;
        List<Individuo> popPais = new ArrayList<>();
        List<Individuo> popFilhos;
        List<Individuo> popMutantes;
        Individuo indPerfeito = null;

        // População inicial
        for (int i = 0; i < nPop; i++) {
            Individuo individuo = indFactory.getIndividuo(maxDomain, minDomain);
            popPais.add(individuo);
        }

        for (int g = 0; g < nGeracoes; g++) {
            popTotal = new ArrayList<>();
            popFilhos = new ArrayList<>();
            popMutantes = new ArrayList<>();

            // Pais
            popTotal.addAll(popPais);

            // Mutantes
            for (int i = 0; i < popPais.size(); i++) {
                List<Double> novosGenes = popPais.get(i).getMutant();
                popMutantes.add(indFactory.getIndividuo(novosGenes));
            }
            popTotal.addAll(popMutantes);

            // Filhos
            Random rand = new Random();
            while (popPais.size() > 1) {
                int index1 = rand.nextInt(popPais.size());
                int index2 = rand.nextInt(popPais.size());

                while (index1 == index2) {
                    index2 = rand.nextInt(popPais.size());
                }
                List<List<Double>> novosGenes = popPais.get(index1).crossover(popPais.get(index2), maxDomain,
                        minDomain);
                popFilhos.add((Individuo) indFactory.getIndividuo(novosGenes.get(0)));
                popFilhos.add((Individuo) indFactory.getIndividuo(novosGenes.get(1)));

                // Nao mudar o indice
                if (index1 <= index2) {
                    popPais.remove(popPais.get(index2));
                    popPais.remove(popPais.get(index1));
                } else {
                    popPais.remove(popPais.get(index1));
                    popPais.remove(popPais.get(index2));
                }
            }
            popTotal.addAll(popFilhos);

            // Avaliando cada individuo
            boolean parada = false;
            for (int i = 0; i < popTotal.size(); i++) {
                if (popTotal.get(i).getAvaliacao() == minGlobal) {
                    parada = true;
                    indPerfeito = popTotal.get(i);
                    break;
                }
            }

            // Avalia se ja achou uma solução
            if (parada) {
                break;
            }

            // Selecionar a elite
            Collections.sort(popTotal);

            double x = Math.floor(nPop / 5);
            for (int i = 0; i < x; i++) {
                popPais.add(popTotal.get(popTotal.size() - 1));
                popTotal.remove(popTotal.size() - 1);
            }

            // Roleta
            for (int i = 0; i < nPop - x; i++) {
                int index = roleta(popTotal, rand, minGlobal, false);
                popPais.add(popTotal.get(--index));
                popTotal.remove(index);
            }
            indPerfeito = popPais.get(0);
        }

        return indPerfeito;
    }

    private int roleta(List<Individuo> popTotal, Random rand, Double minGlobal, boolean isMaximizacao) {
        int index = 0;
        Double sum = 0.0;
        Double fitness = 0.0;
        for (int j = 0; j < popTotal.size(); j++) {
            fitness = popTotal.get(j).getAvaliacao() + Math.abs(minGlobal);
            if (!isMaximizacao && fitness != 0) {
                fitness = 1 / fitness;
            }
            sum += fitness;
        }
        Double sumAux = 0.0;
        Double sumRandom = rand.nextDouble(sum);
        while (sumAux < sumRandom && index < 40) {
            sumAux += popTotal.get(index).getAvaliacao();
            index++;
        }

        return index;
    }
}
