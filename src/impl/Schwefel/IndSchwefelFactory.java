package impl.Schwefel;

import java.util.List;

import model.Individuo;
import model.IndividuoFactory;

public class IndSchwefelFactory implements IndividuoFactory {

    private int dimensao;

    public IndSchwefelFactory(int dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public Individuo getIndividuo(Double maxDomain, Double minDomain) {
        Individuo ind = IndSchwefel.getIndividuo(this.dimensao, maxDomain, minDomain);
        return ind;
    }

    @Override
    public Individuo getIndividuo(List<Double> genes) {
        Individuo ind = IndSchwefel.getIndividuo(genes);
        return ind;
    }
}
