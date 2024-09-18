import java.util.List;

import QuantidadeConsolesVendidos.Controle;
import series.SerieDados;
import series.VisualizadorSeries;

public class Principal {
    public void executar() {
        Controle controle = new Controle();

        List<SerieDados> listaSeries = controle.getListaSeriesCriadas();
        
        VisualizadorSeries visualizacao = new VisualizadorSeries(listaSeries);
        visualizacao.exibir();

        for (SerieDados seriesCriadas : listaSeries){
            System.out.println("Dados da Serie " + seriesCriadas.obterIdentificacaoSerie());

            for (int i=seriesCriadas.obterDiaInicial(); i<=seriesCriadas.obterDiaFinal(); i++){
                System.out.println("Dia " + i + ": " + seriesCriadas.obterDado(i));
            }
        }
    }
}
