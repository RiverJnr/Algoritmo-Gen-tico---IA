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
        IndSchwefel ind = new IndSchwefel(this.dimensao, maxDomain, minDomain);
        return ind;
    }

    @Override
    public Individuo getIndividuo(List<Double> genes) {
        IndSchwefel ind = new IndSchwefel(genes);
        return ind;
    }
}
