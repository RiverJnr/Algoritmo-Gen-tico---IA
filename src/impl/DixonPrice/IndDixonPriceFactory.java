package impl.DixonPrice;

import java.util.List;

import model.Individuo;
import model.IndividuoFactory;

public class IndDixonPriceFactory implements IndividuoFactory {

    private int dimensao;

    public IndDixonPriceFactory(int dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public Individuo getIndividuo(Double maxDomain, Double minDomain) {
        Individuo ind = IndDixonPrice.getIndividuo(this.dimensao, maxDomain, minDomain);
        return ind;
    }

    @Override
    public Individuo getIndividuo(List<Double> genes) {
        Individuo ind = IndDixonPrice.getIndividuo(genes);
        return ind;
    }
}
