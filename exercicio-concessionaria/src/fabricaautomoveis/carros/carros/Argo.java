package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class Argo extends Carro {
    
    public Argo(String cor) {
        super("Argo", Marca.FIAT, cor, 80000, Categoria.POPULAR);
    }   
}
