package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class Montana extends Carro {
    
    public Montana(String cor) {
        super("Montana", Marca.CHEVROLET, cor, 94500, Categoria.PICKUP);
    }
}
