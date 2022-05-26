package impl.CrossInTray;

import model.Individuo;
import model.IndividuoFactory;

public class IndCrossInTrayFactory implements IndividuoFactory {

    private int dimensao;

    public IndCrossInTrayFactory(int dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public Individuo getIndividuo() {
        IndCrossInTray ind = new IndCrossInTray(this.dimensao); 
        return ind;
    }
}
