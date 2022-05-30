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
        IndCrossInTray ind = new IndCrossInTray(this.dimensao, maxDomain, minDomain);
        return ind;
    }

    @Override
    public Individuo getIndividuo(List<Double> genes) {
        IndCrossInTray ind = new IndCrossInTray(genes);
        return ind;
    }
}
