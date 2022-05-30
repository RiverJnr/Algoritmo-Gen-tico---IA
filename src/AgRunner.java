import engine.Ag;
import engine.Ag;
import impl.CrossInTray.IndCrossInTrayFactory;
import impl.DixonPrice.IndDixonPriceFactory;
import impl.Schwefel.IndSchwefelFactory;
import model.Individuo;
import model.IndividuoFactory;

public class AgRunner {
    public static void main(String[] args) throws Exception {
        int dimensao = 3;
        int nPop = 20;
        int nGeracoes = 1000;
        IndividuoFactory indSchwefelFactory = new IndSchwefelFactory(dimensao);
        IndividuoFactory indDixonPriceFactory = new IndDixonPriceFactory(dimensao);
        IndividuoFactory indCrossInTrayFactory = new IndCrossInTrayFactory(2);

        Ag algGenetico = new Ag();

        Individuo melhorCombinacao;
        melhorCombinacao = algGenetico.executar(nPop, indSchwefelFactory, nGeracoes, 0.0, 500.0, -500.0);
        printMelhorInd(melhorCombinacao, "Schwefel Function");

        melhorCombinacao = algGenetico.executar(nPop, indCrossInTrayFactory, nGeracoes, -2.06262, 10.0, -10.0);
        printMelhorInd(melhorCombinacao, "Cross-In-Tray Function");

        melhorCombinacao = algGenetico.executar(nPop, indDixonPriceFactory, nGeracoes, 0.0, 10.0, -10.0);
        printMelhorInd(melhorCombinacao, "Dixon-Price Function");

    }

    public static void printMelhorInd(Individuo melhorCombinacao, String func) {
        System.out.printf("\n%s", func);
        System.out.printf("\nAvaliação: %1.15f\nGenes do melhor indivíduo:\n", melhorCombinacao.getAvaliacao());
        System.out.println(melhorCombinacao.toString());
    }
}
