package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class Gol extends Carro {
    
    public Gol(String cor) {
        super("Gol", Marca.VW, cor, 90000, Categoria.POPULAR);
    }
    
}
