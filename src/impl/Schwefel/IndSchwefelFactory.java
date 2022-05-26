package impl.Schwefel;

import model.Individuo;
import model.IndividuoFactory;

public class IndSchwefelFactory implements IndividuoFactory {

    private int dimensao;

    public IndSchwefelFactory(int dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public Individuo getIndividuo() {
        IndSchwefel ind = new IndSchwefel(this.dimensao);
        return ind;
    }
}
