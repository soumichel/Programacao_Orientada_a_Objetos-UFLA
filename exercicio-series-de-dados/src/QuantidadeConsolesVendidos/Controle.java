package QuantidadeConsolesVendidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import series.SerieDados;

public class Controle {
    private SerieDadosConsoles consolesPlaystation;
    private SerieDadosConsoles consolesXbox;
    
    private List<SerieDados> serieDados = new ArrayList<SerieDados>();

    public Controle() {
        SerieDadosConsoles consolesPlaystation = new SerieDadosConsoles("Consoles Vendidos da Playstation PS5 em Dezembro de 2023", 20, 25);
        SerieDadosConsoles consolesXbox = new SerieDadosConsoles("Consoles Vendidos do Xbox Series X em Dezembro de 2023", 20, 25);

        consolesPlaystation.adicionaDado(20, 656);
        consolesPlaystation.adicionaDado(21, 509);
        consolesPlaystation.adicionaDado(22, 987);
        consolesPlaystation.adicionaDado(23, 876);
        consolesPlaystation.adicionaDado(24, 1076);
        consolesPlaystation.adicionaDado(25, 2098);
        serieDados.add(consolesPlaystation);

        consolesXbox.adicionaDado(20, 798);
        consolesXbox.adicionaDado(21, 424);
        consolesXbox.adicionaDado(22, 806);
        consolesXbox.adicionaDado(23, 936);
        consolesXbox.adicionaDado(24, 1164);
        consolesXbox.adicionaDado(25, 1979);
        serieDados.add(consolesXbox);
        
    }

    public SerieDadosConsoles getConsolesPlaystation() {
        return consolesPlaystation;
    }

    public SerieDadosConsoles getConsolesXbox() {
        return consolesXbox;
    }

    /*
     * Método que retorna uma lista com as duas séries criadas
     */
    public List<SerieDados> getListaSeriesCriadas(){
        return Collections.unmodifiableList(this.serieDados);
    }

}
