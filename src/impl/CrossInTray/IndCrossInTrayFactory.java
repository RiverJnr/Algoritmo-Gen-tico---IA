package impl.CrossInTray;

import java.util.List;

import model.Individuo;
import model.IndividuoFactory;

public class IndCrossInTrayFactory implements IndividuoFactory {

    private int dimensao;

    public IndCrossInTrayFactory(int dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public Individuo getIndividuo(Double maxDomain, Double minDomain) {
        Individuo ind = IndCrossInTray.getIndividuo(this.dimensao, maxDomain, minDomain);
        return ind;
    }

    @Override
    public Individuo getIndividuo(List<Double> genes) {
        Individuo ind = IndCrossInTray.getIndividuo(genes);
        return ind;
    }
}
