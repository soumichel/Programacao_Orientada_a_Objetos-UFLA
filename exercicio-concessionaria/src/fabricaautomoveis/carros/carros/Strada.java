package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class Strada extends Carro {
    
    public Strada(String cor) {
        super("Strada", Marca.FIAT, cor, 95000, Categoria.PICKUP);
    }
    
}
