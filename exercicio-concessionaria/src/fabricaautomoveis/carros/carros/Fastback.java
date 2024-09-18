package fabricaautomoveis.carros.carros;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;

public class Fastback extends Carro {
    
    public Fastback(String cor) {
        super("Fastback", Marca.FIAT, cor, 139000, Categoria.LUXO);
    }
    
}
