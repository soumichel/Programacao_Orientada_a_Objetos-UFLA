package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class Tracker extends Carro {

    public Tracker(String cor) {
        super("Tracker", Marca.CHEVROLET, cor, 154000, Categoria.SUV);
    }
    
}
