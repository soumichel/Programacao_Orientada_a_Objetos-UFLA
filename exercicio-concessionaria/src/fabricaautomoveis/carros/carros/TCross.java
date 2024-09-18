package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class TCross extends Carro{
    
    public TCross(String cor) {
        super("T-Cross", Marca.VW, cor, 127000, Categoria.SUV);
    }
}
