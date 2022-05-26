package impl.DixonPrice;

import model.Individuo;
import model.IndividuoFactory;

public class IndDixonPriceFactory implements IndividuoFactory {

    private int dimensao;

    public IndDixonPriceFactory(int dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public Individuo getIndividuo() {
        IndDixonPrice ind = new IndDixonPrice(this.dimensao);
        return ind;
    }
}
